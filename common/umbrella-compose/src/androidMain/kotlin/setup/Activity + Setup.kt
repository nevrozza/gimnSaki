package setup

import LocalFullScreenConstraints
import theme.LocalThemeManager
import SettingsRepository
import android.annotation.SuppressLint
import android.os.Build
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.DpSize
import androidx.core.view.ViewCompat
import com.adeo.kviewmodel.odyssey.setupWithViewModels
import commonLog
import di.Inject

import navigation.NavigationSource
import navigation.NavigationTree
import navigation.generateGraph
import ru.alexgladkov.odyssey.compose.base.Navigator
import ru.alexgladkov.odyssey.compose.extensions.setupWithActivity
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.alexgladkov.odyssey.compose.navigation.modal_navigation.ModalNavigator
import ru.alexgladkov.odyssey.compose.navigation.modal_navigation.configuration.DefaultModalConfiguration
import ru.alexgladkov.odyssey.core.configuration.DisplayType
import theme.AppTheme
import theme.ThemeManager
import theme.adaptive.LocalWindowScreen
import theme.adaptive.WindowSizeClass
import theme.schemeChooser

import theme.ThemeColors
import theme.ThemeTint


@SuppressLint("CoroutineCreationDuringComposition", "UnrememberedMutableState")
fun ComponentActivity.setupThemedNavigation() {

    val rootController =
        RootComposeBuilder().apply { generateGraph(NavigationSource.Android) }.build()
    rootController.setupWithActivity(this)
    rootController.setupWithViewModels()




    setContent {
        val settingsRepository: SettingsRepository = Inject.instance()

        val themeManager = ThemeManager(mutableStateOf(settingsRepository.fetchThemeColor()), mutableStateOf(settingsRepository.fetchThemeTint()))

        if (themeManager.color.value.isBlank()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                themeManager.color.value = ThemeColors.Dynamic.name
                settingsRepository.saveThemeColor(ThemeColors.Dynamic.name)
            }
        }
        themeInit(themeManager, settingsRepository)


        val tint = themeManager.tint.value
        val color = themeManager.color.value
        val darkTheme: Boolean =
            if (tint == ThemeTint.Auto.name) isSystemInDarkTheme()
            else tint == ThemeTint.Dark.name

        val colorScheme =
            if (color == ThemeColors.Dynamic.name) {
                if (darkTheme) {
                    dynamicDarkColorScheme(applicationContext)
                } else {
                    dynamicLightColorScheme(applicationContext)
                }
            } else {
                schemeChooser(darkTheme, color)
            }


        val backgroundColor = colorScheme.background
        rootController.backgroundColor = backgroundColor

        val view = LocalView.current

        SideEffect {
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = !darkTheme
        }


        BoxWithConstraints(Modifier.fillMaxSize()) {
            val windowScreen = WindowSizeClass.calculateScreen(DpSize(this.maxWidth, this.maxHeight))
            commonLog("${this.maxWidth} ${this.maxHeight}=${windowScreen}")
            CompositionLocalProvider(
                LocalRootController provides rootController,
                LocalWindowScreen provides windowScreen,
                LocalFullScreenConstraints provides this,
                LocalThemeManager provides themeManager
            ) {

                AppTheme(colorScheme = colorScheme) {
                    commonLog(themeManager.toString())
                    ModalNavigator(
                        DefaultModalConfiguration(backgroundColor, DisplayType.EdgeToEdge)
                    ) {
                        Navigator(startScreen = NavigationTree.Splash.SplashScreen.name)
                    }


                }
            }
        }


    }
}

