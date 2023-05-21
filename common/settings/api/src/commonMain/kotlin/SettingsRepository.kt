interface SettingsRepository {

    fun saveThemeTint(tint: String)

    fun fetchThemeTint(): String

    fun saveThemeColor(color: String)

    fun fetchThemeColor(): String

}