package database

import PlatformConfiguration
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema


expect class DbDriverFactory(platformConfiguration: PlatformConfiguration) {
    fun createDriver(schema: SqlSchema, name: String): SqlDriver
}