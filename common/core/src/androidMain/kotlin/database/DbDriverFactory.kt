package database

import PlatformConfiguration
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DbDriverFactory actual constructor(private val platformConfiguration: PlatformConfiguration) {
    actual fun createDriver(
        schema: SqlDriver.Schema,
        name: String
    ): SqlDriver = AndroidSqliteDriver(schema, platformConfiguration.androidContext, name)
}