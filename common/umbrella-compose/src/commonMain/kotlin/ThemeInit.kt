import SettingsRepository
import androidx.compose.runtime.Composable
import dynamic.isCanInDynamic
import theme.LocalThemeManager
import theme.ThemeManager
import theme.ThemeColors
import theme.ThemeTint

fun colorInit(settingsRepository: SettingsRepository): String {
    return when {
        settingsRepository.fetchThemeColor().isBlank() -> {
            settingsRepository.saveThemeColor(ThemeColors.Default.name)
            ThemeColors.Default.name
        }
        settingsRepository.fetchThemeColor().isBlank() && isCanInDynamic() -> {
            settingsRepository.saveThemeColor(ThemeColors.Dynamic.name)
            ThemeColors.Dynamic.name
        }
        else -> {
            settingsRepository.fetchThemeColor()
        }
    }
}

fun tintInit(settingsRepository: SettingsRepository): String {
    return when {
        settingsRepository.fetchThemeTint().isBlank() -> {
            settingsRepository.saveThemeTint(ThemeTint.Auto.name)
            ThemeTint.Auto.name
        }
        else -> {
            settingsRepository.fetchThemeTint()
        }
    }
}

//fun themeInit(themeManager: ThemeManager, settingsRepository: SettingsRepository) {
//
//    if(settingsRepository.fetchThemeTint().isBlank()
//        && settingsRepository.fetchThemeColor().isBlank()) {
//        themeManager.color.value = ThemeColors.Default.name
//        themeManager.color.value = ThemeTint.Auto.name
//        settingsRepository.saveThemeColor(ThemeColors.Default.name)
//        settingsRepository.saveThemeTint(ThemeTint.Auto.name)
//    }
//}