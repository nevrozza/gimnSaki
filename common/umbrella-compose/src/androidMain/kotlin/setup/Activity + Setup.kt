package setup

import SettingsRepository
import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import com.adeo.kviewmodel.odyssey.setupWithViewModels

import di.Inject
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch

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
import theme.defaultDarkPalette
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
        val settingsRepository = remember { mutableStateOf(Inject.instance() as SettingsRepository) }

        if(magicForUpdateSettings.value) {
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

        val colorScheme by mutableStateOf (if (color == ThemeColors.Dynamic.name) {
            if (darkTheme) {
                dynamicDarkColorScheme(applicationContext)
            } else {
                dynamicLightColorScheme(applicationContext)
            }
        } else {
            schemeChooser(darkTheme, color)
        })

        val backgroundColor = colorScheme.background
        rootController.backgroundColor = backgroundColor

        val view = LocalView.current

        SideEffect {
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = !darkTheme
        }

        CompositionLocalProvider(
            LocalRootController provides rootController
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

