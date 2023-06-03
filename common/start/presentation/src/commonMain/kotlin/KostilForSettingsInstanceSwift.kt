import di.Inject

class KostilForSettingsInstanceSwift {
    fun settingsRepositorySwift(): SettingsRepository {
        return Inject.instance() as SettingsRepository
    }
}
