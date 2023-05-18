package database

import PlatformConfiguration
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver

actual class DbDriverFactory actual constructor(platformConfiguration: PlatformConfiguration) {
    actual fun createDriver(schema: SqlDriver.Schema, name: String): SqlDriver = JdbcSqliteDriver("jdbc:sqlite:$name")
}