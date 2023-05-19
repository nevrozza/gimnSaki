package settings

import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import com.russhwolf.settings.set
import themeCodes.ThemeCodes

class SettingsSettingsDataSource(
    private val settings: Settings
) {
    fun saveThemeCode(themeCode: Int){
        settings[themeKey] = themeCode
    }

    fun fetchThemeCode(): Int {
        return settings[themeKey, ThemeCodes.default]
    }

    companion object {
        const val themeKey = "themeKey"
    }
}