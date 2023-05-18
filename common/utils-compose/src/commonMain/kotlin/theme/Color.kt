package theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color


data class GimnSakiColors(
    val primaryBackground: Color,
    val primaryAction: Color
)

val lightPalette = GimnSakiColors(
    primaryBackground = Color.White,
    primaryAction = Color.Blue
)

val darkPalette = GimnSakiColors(
    primaryBackground = Color.Black,
    primaryAction = Color.Blue
)

val LocalColorProvider = staticCompositionLocalOf<GimnSakiColors> { error("No default implementation") }