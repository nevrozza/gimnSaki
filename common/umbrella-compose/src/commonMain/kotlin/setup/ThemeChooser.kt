package setup

import SettingsRepository
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import theme.defaultDarkPalette
import theme.defaultLightPalette
import theme.greenDarkPalette
import theme.greenLightPalette
import theme.redDarkPalette
import theme.redLightPalette
import theme.yellowDarkPalette
import theme.yellowLightPalette
import themeCodes.ThemeColors
import themeCodes.ThemeTint

@Composable
fun schemeChooser(settingsRepository: SettingsRepository, isDark: Boolean, color: String): ColorScheme {
    if(settingsRepository.fetchThemeTint().isBlank()
        && settingsRepository.fetchThemeColor().isBlank()) {
        settingsRepository.saveThemeColor(ThemeColors.Default.name)
        settingsRepository.saveThemeTint(ThemeTint.Auto.name)
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