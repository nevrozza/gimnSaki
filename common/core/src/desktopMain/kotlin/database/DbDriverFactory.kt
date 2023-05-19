package database

import PlatformConfiguration
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver


actual class DbDriverFactory actual constructor(platformConfiguration: PlatformConfiguration) {
    actual fun createDriver(schema: SqlSchema, name: String): SqlDriver = JdbcSqliteDriver("jdbc:sqlite:$name")
}