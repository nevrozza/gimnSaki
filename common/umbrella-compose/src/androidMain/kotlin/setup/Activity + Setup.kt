package setup

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import colorInit
import root
import root.RootComponent
import theme.LocalThemeManager
import theme.ThemeManager
import theme.ThemeTint


fun ComponentActivity.init(root: RootComponent) {
    setContent {


            root(root)

    }

}
//
//@SuppressLint("CoroutineCreationDuringComposition", "UnrememberedMutableState")
//fun ComponentActivity.setupThemedNavigation() {
//
//    val rootController =
//        RootComposeBuilder().apply { generateGraph(NavigationSource.Android) }.build()
//    rootController.setupWithActivity(this)
//    rootController.setupWithViewModels()
//
//
//
//
//    setContent {
//        val settingsRepository: SettingsRepository = Inject.instance()
//        val tint = settingsRepository.fetchThemeTint()
//
//        val isDark: Boolean =
//            if (tint == ThemeTint.Auto.name) isSystemInDarkTheme()
//            else tint == ThemeTint.Dark.name
//        val themeManager = ThemeManager(mutableStateOf(settingsRepository.fetchThemeColor()), mutableStateOf(settingsRepository.fetchThemeTint()), mutableStateOf(isDark))
//
//        if (themeManager.color.value.isBlank()) {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
//                themeManager.color.value = ThemeColors.Dynamic.name
//                settingsRepository.saveThemeColor(ThemeColors.Dynamic.name)
//            }
//        }
//        themeInit(themeManager, settingsRepository)
//
//        val color = themeManager.color.value
//
//
//        val colorScheme =
//            if (color == ThemeColors.Dynamic.name) {
//                if (isDark) {
//                    dynamicDarkColorScheme(applicationContext)
//                } else {
//                    dynamicLightColorScheme(applicationContext)
//                }
//            } else {
//                schemeChooser(isDark, color)
//            }
//
//
//        val backgroundColor = colorScheme.background
//        rootController.backgroundColor = backgroundColor
//
//        val view = LocalView.current
//
//        SideEffect {
//            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = !isDark
//        }
//
//
//        BoxWithConstraints(Modifier.fillMaxSize()) {
//            val windowScreen = WindowSizeClass.calculateScreen(DpSize(this.maxWidth, this.maxHeight))
//            commonLog("${this.maxWidth} ${this.maxHeight}=${windowScreen}")
//            CompositionLocalProvider(
//                LocalRootController provides rootController,
//                LocalWindowScreen provides windowScreen,
//                LocalFullScreenConstraints provides this,
//                LocalThemeManager provides themeManager
//            ) {
//
//                AppTheme(colorScheme = colorScheme) {
//                    commonLog(themeManager.toString())
//                    ModalNavigator(
//                        DefaultModalConfiguration(backgroundColor, DisplayType.EdgeToEdge)
//                    ) {
//                        Navigator(startScreen = NavigationTree.Splash.SplashScreen.name)
//                    }
//
//
//                }
//            }
//        }
//
//
//    }
//}

