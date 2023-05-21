import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.singleton
import settings.SettingsSettingsDataSource

val settingsModule = DI.Module("settingsModule") {
    bind<SettingsRepository>() with singleton {
        SettingsRepositoryImpl(instance())
    }

    bind<SettingsSettingsDataSource>() with provider {
        SettingsSettingsDataSource(instance())
    }
}