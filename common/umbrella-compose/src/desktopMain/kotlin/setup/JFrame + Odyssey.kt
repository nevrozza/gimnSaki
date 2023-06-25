package setup

import androidx.compose.ui.awt.ComposePanel
import root
import root.RootComponent
import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.JFrame
import javax.swing.WindowConstants

fun JFrame.init(root: RootComponent) {

    defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
    title = "gimnSaki admin"

    val composePanel = ComposePanel()
    composePanel.setContent {
        root(root, "pc")
    }

    minimumSize = Dimension(360, 640)
    contentPane.add(composePanel, BorderLayout.CENTER)
    setSize(1300, 700)
    setLocationRelativeTo(null)
    isVisible = true
}

//fun JFrame.setupThemedNavigation() {
//    val rootController = RootComposeBuilder().apply { generateGraph(NavigationSource.Desktop) }.build()
//    defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
//    title = "gimnSaki admin"
//
//
//    val composePanel = ComposePanel()
//    composePanel.setContent {
//        val settingsRepository: SettingsRepository = Inject.instance()
//        val tint = settingsRepository.fetchThemeTint()
//
//        val isDark: Boolean =
//            if (tint == ThemeTint.Auto.name) isSystemInDarkTheme()
//            else tint == ThemeTint.Dark.name
//        val themeManager = ThemeManager(mutableStateOf(settingsRepository.fetchThemeColor()), mutableStateOf(settingsRepository.fetchThemeTint()), mutableStateOf(isDark))
//
//        themeInit(themeManager, settingsRepository)
//        val color = themeManager.color.value
//
//        val colorScheme = schemeChooser(isDark, color)
//        val backgroundColor = colorScheme.background
//
//        rootController.backgroundColor = backgroundColor
//
//        BoxWithConstraints(Modifier.fillMaxSize()) {
//            val windowScreen = WindowSizeClass.calculateScreen(DpSize(this.maxWidth, this.maxHeight), "pc")
//
//            CompositionLocalProvider(
//                LocalRootController provides rootController,
//                LocalWindowScreen provides windowScreen,
//                LocalFullScreenConstraints provides this,
//                LocalThemeManager provides themeManager
//            ) {
//
//
//
//
//                AppTheme(colorScheme = colorScheme) {
//
//
//
//                    ModalNavigator(
//                        DefaultModalConfiguration(
//                            backgroundColor,
//                            DisplayType.EdgeToEdge
//                        )
//                    ) {
//                        Navigator(NavigationTree.Splash.SplashScreen.name)
//                    }
//                }
//            }
//        }
//    }
//    minimumSize = Dimension(360, 640)
//    contentPane.add(composePanel, BorderLayout.CENTER)
//    setSize(1300, 700)
//    setLocationRelativeTo(null)
//    isVisible = true
//}