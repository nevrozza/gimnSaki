package theme.adaptive

import androidx.compose.runtime.staticCompositionLocalOf
import theme.WindowScreen


val LocalWindowScreen = staticCompositionLocalOf<WindowScreen>{
    error("No windowSize provided")
}

