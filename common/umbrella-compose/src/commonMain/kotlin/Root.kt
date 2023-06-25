import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import di.Inject
import dynamic.dynamicDarkScheme
import dynamic.dynamicLightScheme
import dynamic.isCanInDynamic
import root.RootComponent
import theme.AppTheme
import theme.LocalThemeManager
import theme.ThemeColors
import theme.ThemeManager
import theme.ThemeTint
import theme.adaptive.WindowSizeClass
import theme.schemeChooser

@Composable
fun root(root: RootComponent, device: String = "phone") {

    val settingsRepository: SettingsRepository = Inject.instance()



    val themeManager = remember {
        ThemeManager(color = mutableStateOf(colorInit(settingsRepository)), tint = mutableStateOf(tintInit(settingsRepository)))
    }



    themeManager.isDark.value = if (themeManager.tint.value == ThemeTint.Auto.name) isSystemInDarkTheme()
            else themeManager.tint.value  == ThemeTint.Dark.name

    val colorScheme =
        if (themeManager.color.value == ThemeColors.Dynamic.name) {
            if (themeManager.isDark.value) {
                dynamicDarkScheme()!!
            } else {
                dynamicLightScheme()!!
            }
        }
        else if(themeManager.color.value == ThemeColors.Dynamic.name && !isCanInDynamic()) {
            schemeChooser(themeManager.isDark.value, ThemeColors.Default.name)
        }
        else {
            schemeChooser(themeManager.isDark.value, themeManager.color.value)
        }


    BoxWithConstraints() {
        themeManager.size = this
        themeManager.orientation.value = WindowSizeClass.calculateScreen(size = DpSize(this.maxWidth, this.maxHeight), device)

        CompositionLocalProvider(
            LocalThemeManager provides themeManager
        ) {
            AppTheme(colorScheme = colorScheme) {
                Surface(modifier = Modifier.fillMaxSize()) {

                    RootContent(root)
                }
            }
        }

    }


}