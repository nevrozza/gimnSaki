interface SettingsRepository {

    fun saveThemeCode(code: Int)

    fun fetchThemeCode(): Int

}