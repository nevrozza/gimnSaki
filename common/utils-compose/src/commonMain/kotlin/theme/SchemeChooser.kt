package theme

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import themeCodes.ThemeColors


@Composable
fun schemeChooser(isDark: Boolean, color: String): ColorScheme {
    BoxWithConstraints {
        this
    }
    return if(isDark) {
            when(color) {
                ThemeColors.Default.name -> defaultDarkPalette()
                ThemeColors.Green.name -> greenDarkPalette()
                ThemeColors.Red.name -> redDarkPalette()
                ThemeColors.Yellow.name -> yellowDarkPalette()
                else -> defaultDarkPalette()

            }
        } else {
            when(color) {
                ThemeColors.Default.name -> defaultLightPalette()
                ThemeColors.Green.name -> greenLightPalette()
                ThemeColors.Red.name -> redLightPalette()
                ThemeColors.Yellow.name -> yellowLightPalette()
                else -> defaultLightPalette()
            }
        }
}