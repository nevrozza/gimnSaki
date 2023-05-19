package setup

import android.app.Activity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import com.adeo.kviewmodel.odyssey.setupWithViewModels
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
import theme.Theme


import theme.lightPalette

fun ComponentActivity.setupThemedNavigation() {
    val rootController = RootComposeBuilder().apply { generateGraph(NavigationSource.Android) }.build()
    rootController.setupWithActivity(this)
    rootController.setupWithViewModels()


    setContent{


        AppTheme(colorScheme = lightPalette) {
            val view = LocalView.current
            val backgroundColor = Theme.colors.background
            if (!view.isInEditMode) {
                val darkTheme: Boolean = isSystemInDarkTheme()
                SideEffect {
                    (view.context as Activity).window.statusBarColor = backgroundColor.toArgb()
                    ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
                }
            }

            rootController.backgroundColor = backgroundColor

            CompositionLocalProvider(
                LocalRootController provides rootController
            ) {
                ModalNavigator(
                    DefaultModalConfiguration(backgroundColor, DisplayType.EdgeToEdge)
                ) {
                    Navigator(startScreen = NavigationTree.Splash.SplashScreen.name)
                }
            }
        }
    }
}