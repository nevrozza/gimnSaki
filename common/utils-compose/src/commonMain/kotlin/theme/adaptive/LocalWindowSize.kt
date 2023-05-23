package theme.adaptive

import androidx.compose.runtime.staticCompositionLocalOf


val LocalWindowSize = staticCompositionLocalOf<WindowSizeClass>{
    error("No windowSize provided")
}