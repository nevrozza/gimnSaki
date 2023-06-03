package setup

import SettingsRepository
import theme.ThemeManager
import theme.ThemeColors
import theme.ThemeTint


fun themeInit(themeManager: ThemeManager, settingsRepository: SettingsRepository) {

    if(themeManager.tint.value.isBlank()
        && themeManager.color.value.isBlank()) {
        themeManager.color.value = ThemeColors.Default.name
        themeManager.color.value = ThemeTint.Auto.name
        settingsRepository.saveThemeColor(ThemeColors.Default.name)
        settingsRepository.saveThemeTint(ThemeTint.Auto.name)
    }
}