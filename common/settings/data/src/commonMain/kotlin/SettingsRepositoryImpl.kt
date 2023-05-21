import settings.SettingsSettingsDataSource

class SettingsRepositoryImpl(
    private val cacheDataSource: SettingsSettingsDataSource
): SettingsRepository {
    override fun saveThemeTint(tint: String) {
        cacheDataSource.saveThemeTint(tint)
    }

    override fun fetchThemeTint(): String {
        return cacheDataSource.fetchThemeTint()
    }

    override fun saveThemeColor(color: String) {
        cacheDataSource.saveThemeColor(color)
    }

    override fun fetchThemeColor(): String {
        return cacheDataSource.fetchThemeColor()
    }

}