package setup

import SettingsRepository
import androidx.compose.runtime.Composable
import theme.LocalThemeManager
import theme.ThemeManager
import theme.ThemeColors
import theme.ThemeTint


fun themeInit(themeManager: ThemeManager, settingsRepository: SettingsRepository) {

    if(settingsRepository.fetchThemeTint().isBlank()
        && settingsRepository.fetchThemeColor().isBlank()) {
        themeManager.color.value = ThemeColors.Default.name
        themeManager.color.value = ThemeTint.Auto.name
        settingsRepository.saveThemeColor(ThemeColors.Default.name)
        settingsRepository.saveThemeTint(ThemeTint.Auto.name)
    }
}