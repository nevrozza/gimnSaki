import di.Inject

class FuckSwift {
    fun settingsRepository(): SettingsRepository {
        return Inject.instance() as SettingsRepository
    }
}