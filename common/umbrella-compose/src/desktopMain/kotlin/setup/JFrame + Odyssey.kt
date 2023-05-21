package setup

import SettingsRepository
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.awt.ComposePanel
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
import java.awt.BorderLayout
import javax.swing.JFrame
import javax.swing.WindowConstants

fun JFrame.setupThemedNavigation() {
    val rootController = RootComposeBuilder().apply { generateGraph(NavigationSource.Desktop) }.build()

    defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
    title = "gimnSaki admin"

    val composePanel = ComposePanel()
    composePanel.setContent {
        CompositionLocalProvider(
            LocalRootController provides rootController
        ) {
            val settingsRepository: SettingsRepository = Inject.instance()
            val tint = settingsRepository.fetchThemeTint()
            val color = settingsRepository.fetchThemeColor()
            val colorScheme = schemeChooser(settingsRepository, tint, color)
            AppTheme(colorScheme = colorScheme) {


                val backgroundColor = MaterialTheme.colorScheme.background
                rootController.backgroundColor = backgroundColor

                ModalNavigator(DefaultModalConfiguration(backgroundColor, DisplayType.EdgeToEdge)) {
                    Navigator(NavigationTree.Splash.SplashScreen.name)
                }
            }
        }
    }

    contentPane.add(composePanel, BorderLayout.CENTER)
    setSize(1300, 700)
    setLocationRelativeTo(null)
    isVisible = true
}