plugins {
    id("android-setup")
    id("multiplatform-setup")
    id("com.squareup.sqldelight")
    id("dev.icerock.mobile.multiplatform-resources")
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
                api(Dependencies.SqlDelight.core)

                api(Dependencies.Moko.Resources.res)
                api(Dependencies.Moko.Resources.compose)
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
    database("Database") {
        packageName = "com.gimnsaki.app"
        schemaOutputDirectory = file("src/commonMain/sqldelight/databases/schema")
        migrationOutputDirectory = file("src/commonMain/sqldelight/databases/migrations")
    }
}

multiplatformResources {
    multiplatformResourcesPackage = "com.gimnsaki.app"
    iosBaseLocalizationRegion = "ru"
}