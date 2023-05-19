package theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color


val lightPalette = lightColorScheme()

val darkPalette = ColorScheme(
    primary = Color(0xFF0b57d0),
    onPrimary = Color(0xFFFFF),
    primaryContainer = Color(0xFFd3e3fd),
    onPrimaryContainer = Color(0xFF041e49),

)

val LocalColorProvider = staticCompositionLocalOf<ColorScheme> { error("No default implementation") }