plugins {
    id("android-setup")
    id("multiplatform-setup")
    id("app.cash.sqldelight") version "2.0.0-alpha05"
    kotlin("plugin.serialization")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":common:utils"))
                implementation(project(":common:auth:api"))

                api(Dependencies.Kotlin.Serialization.serialization)
                api(Dependencies.Kotlin.Coroutines.core)

                api(Dependencies.Ktor.core)
                implementation(Dependencies.Ktor.json)
                implementation(Dependencies.Ktor.kotlinx_json)
                implementation(Dependencies.Ktor.serialization)
                implementation(Dependencies.Ktor.logging)
                implementation(Dependencies.Ktor.negotiation)

                implementation(Dependencies.Settings.core)
                implementation(Dependencies.Settings.noargs)

                api(Dependencies.Kodein.core)

            }
        }

        androidMain {
            dependencies {
                implementation(Dependencies.Ktor.android)
                implementation(Dependencies.SqlDelight.android)
            }
        }

        iosMain {
            dependencies {
                implementation(Dependencies.Ktor.ios)
                implementation(Dependencies.SqlDelight.ios)
            }
        }

        desktopMain {
            dependencies {
                implementation(Dependencies.Ktor.okhttp)
                implementation(Dependencies.SqlDelight.desktop)
            }
        }
    }
}

sqldelight {
    databases {
        create("Database") {
            packageName.set("com.gimnsaki.app")
            schemaOutputDirectory.set(file("src/commonMain/sqldelight/databases/schema"))
            migrationOutputDirectory.set(file("src/commonMain/sqldelight/databases/migrations"))
        }
    }
}
