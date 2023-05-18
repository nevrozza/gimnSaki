import database.databaseModule
import json.serializationModule
import ktor.ktorModule
import org.kodein.di.DI
import settings.settingsModule

var coreModule = DI.Module("coreModule") {
    importAll(
        ktorModule,
        serializationModule,
        settingsModule,
        databaseModule
    )
}