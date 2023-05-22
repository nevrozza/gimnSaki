package setup

import SettingsRepository
import android.annotation.SuppressLint
import android.os.Build
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import com.adeo.kviewmodel.odyssey.setupWithViewModels

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
import theme.adaptive.LocalK
import theme.adaptive.K
import theme.magicForUpdateSettings
import theme.schemeChooser

import themeCodes.ThemeColors
import themeCodes.ThemeTint


@SuppressLint("CoroutineCreationDuringComposition", "UnrememberedMutableState")
fun ComponentActivity.setupThemedNavigation() {

    val rootController =
        RootComposeBuilder().apply { generateGraph(NavigationSource.Android) }.build()
    rootController.setupWithActivity(this)
    rootController.setupWithViewModels()




    setContent {
        val settingsRepository =
            remember { mutableStateOf(Inject.instance() as SettingsRepository) }

        if (magicForUpdateSettings.value) {
            settingsRepository.value = Inject.instance()
            magicForUpdateSettings.value = false
        }

        if (settingsRepository.value.fetchThemeColor().isBlank()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                settingsRepository.value.saveThemeColor(ThemeColors.Dynamic.name)
            }
        }
        themeInit(settingsRepository.value)


        val tint = settingsRepository.value.fetchThemeTint()
        val color = settingsRepository.value.fetchThemeColor()
        val darkTheme: Boolean =
            if (tint == ThemeTint.Auto.name) isSystemInDarkTheme()
            else tint == ThemeTint.Dark.name

        val colorScheme by mutableStateOf(
            if (color == ThemeColors.Dynamic.name) {
                if (darkTheme) {
                    dynamicDarkColorScheme(applicationContext)
                } else {
                    dynamicLightColorScheme(applicationContext)
                }
            } else {
                schemeChooser(darkTheme, color)
            }
        )

        val backgroundColor = colorScheme.background
        rootController.backgroundColor = backgroundColor

        val configuration = LocalConfiguration.current
        val k = remember {
            K(
                w = configuration.screenWidthDp.toFloat() / 393,
                h = configuration.screenHeightDp.toFloat() / 783
            )
        }

        val view = LocalView.current

        SideEffect {
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = !darkTheme
        }

        CompositionLocalProvider(
            LocalRootController provides rootController,
            LocalK provides k
        ) {

            AppTheme(colorScheme = colorScheme) {
                ModalNavigator(
                    DefaultModalConfiguration(backgroundColor, DisplayType.EdgeToEdge)
                ) {
                    Navigator(startScreen = NavigationTree.Splash.SplashScreen.name)
                }


            }
        }


    }
}

