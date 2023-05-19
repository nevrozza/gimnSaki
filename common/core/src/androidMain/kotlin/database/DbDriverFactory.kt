package database

import PlatformConfiguration
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import app.cash.sqldelight.driver.android.AndroidSqliteDriver


actual class DbDriverFactory actual constructor(private val platformConfiguration: PlatformConfiguration) {
    actual fun createDriver(
        schema: SqlSchema,
        name: String
    ): SqlDriver = AndroidSqliteDriver(schema, platformConfiguration.androidContext, name)
}