package settings

import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import com.russhwolf.settings.set

class SettingsSettingsDataSource(
    private val settings: Settings
) {
    fun saveThemeTint(themeTint: String){
        settings[themeTintKey] = themeTint
    }

    fun fetchThemeTint(): String {
        return settings[themeTintKey, ""]
    }

    fun saveThemeColor(themeColor: String){
        settings[themeColorKey] = themeColor
    }

    fun fetchThemeColor(): String {
        return settings[themeColorKey, ""]
    }

    companion object {
        const val themeTintKey = "themeTintKey"
        const val themeColorKey = "themeColorKey"
    }
}
