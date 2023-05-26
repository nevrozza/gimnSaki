package theme.adaptive

import androidx.compose.runtime.staticCompositionLocalOf



val LocalWindowScreen = staticCompositionLocalOf<WindowScreen>{
    error("No windowSize provided")
}