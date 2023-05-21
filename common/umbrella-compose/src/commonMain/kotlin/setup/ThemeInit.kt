package setup

import SettingsRepository
import themeCodes.ThemeColors
import themeCodes.ThemeTint

fun themeInit(settingsRepository: SettingsRepository) {
    if(settingsRepository.fetchThemeTint().isBlank()
        && settingsRepository.fetchThemeColor().isBlank()) {
        settingsRepository.saveThemeColor(ThemeColors.Default.name)
        settingsRepository.saveThemeTint(ThemeTint.Auto.name)
    }
}