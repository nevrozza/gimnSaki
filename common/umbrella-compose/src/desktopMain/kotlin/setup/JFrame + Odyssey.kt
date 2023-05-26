package setup

import LocalFullScreenConstraints
import SettingsRepository
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.ComposePanel
import androidx.compose.ui.unit.DpSize
import di.Inject
import navigation.NavigationSource
import navigation.NavigationTree
import navigation.generateGraph
import ru.alexgladkov.odyssey.compose.base.Navigator
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.alexgladkov.odyssey.compose.navigation.modal_navigation.ModalNavigator
import ru.alexgladkov.odyssey.compose.navigation.modal_navigation.configuration.DefaultModalConfiguration
import ru.alexgladkov.odyssey.core.configuration.DisplayType
import theme.AppTheme
import theme.adaptive.LocalWindowScreen
import theme.adaptive.WindowSizeClass
import theme.magicForUpdateSettings
import theme.schemeChooser
import themeCodes.ThemeTint
import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.JFrame
import javax.swing.WindowConstants

fun JFrame.setupThemedNavigation() {
    val rootController = RootComposeBuilder().apply { generateGraph(NavigationSource.Desktop) }.build()

    defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
    title = "gimnSaki admin"


    val composePanel = ComposePanel()
    composePanel.setContent {
        BoxWithConstraints(Modifier.fillMaxSize()) {
            val windowScreen = WindowSizeClass.calculateScreen(DpSize(this.maxWidth, this.maxHeight))
            CompositionLocalProvider(
                LocalRootController provides rootController,
                LocalWindowScreen provides windowScreen,
                LocalFullScreenConstraints provides this
            ) {

                val settingsRepository =
                    remember { mutableStateOf(Inject.instance() as SettingsRepository) }

                if (magicForUpdateSettings.value) {
                    settingsRepository.value = Inject.instance()
                    magicForUpdateSettings.value = false
                }
                themeInit(settingsRepository.value)
                val tint = settingsRepository.value.fetchThemeTint()
                val color = settingsRepository.value.fetchThemeColor()

                val darkTheme: Boolean =
                    if (tint == ThemeTint.Auto.name) isSystemInDarkTheme()
                    else tint == ThemeTint.Dark.name

                val colorScheme = mutableStateOf( schemeChooser(darkTheme, color) )
                AppTheme(colorScheme = colorScheme.value) {


                    val backgroundColor = MaterialTheme.colorScheme.background
                    rootController.backgroundColor = backgroundColor

                    ModalNavigator(
                        DefaultModalConfiguration(
                            backgroundColor,
                            DisplayType.EdgeToEdge
                        )
                    ) {
                        Navigator(NavigationTree.Splash.SplashScreen.name)
                    }
                }
            }
        }
    }
    minimumSize = Dimension(360, 640)
    contentPane.add(composePanel, BorderLayout.CENTER)
    setSize(1300, 700)
    setLocationRelativeTo(null)
    isVisible = true
}