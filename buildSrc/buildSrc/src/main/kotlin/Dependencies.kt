object Dependencies {

    object Kodein {
        const val core = "org.kodein.di:kodein-di:7.20.1"
    }

    object Settings {
        const val core = "com.russhwolf:multiplatform-settings:1.0.0-RC"
        const val noargs = "com.russhwolf:multiplatform-settings-no-arg:1.0.0-RC"
    }

    object Kotlin {
        private const val version = "1.8.10"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"

        object Serialization {
            const val gradlePlugin = "org.jetbrains.kotlin:kotlin-serialization:$version"
            const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.3"
        }

        object Coroutines {
            private const val version = "1.7.0-RC"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        }

        object DateTime {
            private const val version = "0.4.0"
            const val dateTime = "org.jetbrains.kotlinx:kotlinx-datetime:$version"
        }
    }

    object Compose {
        private const val version = "1.4.0"
        const val gradlePlugin = "org.jetbrains.compose:compose-gradle-plugin:$version"
    }

    object Ktor {
        private const val version = "2.1.0"
        const val core = "io.ktor:ktor-client-core:$version"
        const val json = "io.ktor:ktor-client-json:$version"
        const val serialization = "io.ktor:ktor-client-serialization:$version"
        const val logging = "io.ktor:ktor-client-logging:$version"
        const val negotiation = "io.ktor:ktor-client-content-negotiation:$version"
        const val kotlinx_json = "io.ktor:ktor-serialization-kotlinx-json:$version"
        const val android = "io.ktor:ktor-client-android:$version"
        const val ios = "io.ktor:ktor-client-ios:$version"
        const val okhttp = "io.ktor:ktor-client-okhttp:$version"
    }

    object Moko {
        object Resources {
            private const val version = "0.22.3"

            const val gradlePlugin = "dev.icerock.moko:resources-generator:$version"
            const val res = "dev.icerock.moko:resources:$version"
            const val compose = "dev.icerock.moko:resources-compose:$version"
            const val graphics = "dev.icerock.moko:graphics:0.9.0"
        }
    }

    object SqlDelight {
        private const val version = "2.0.0-alpha05"
        const val gradlePlugin = "app.cash.sqldelight:gradle-plugin:$version"
        const val core = "app.cash.sqldelight:runtime:$version"
        const val android = "app.cash.sqldelight:android-driver:$version"
        const val ios = "app.cash.sqldelight:native-driver:$version"
        const val desktop = "app.cash.sqldelight:sqlite-driver:$version"
    }

    object Android {
        private const val version = "8.0.1"
        const val gradlePlugin = "com.android.tools.build:gradle:$version"
        const val composeActivity = "androidx.activity:activity-compose:1.7.0"
        const val runtime = "androidx.compose.runtime:runtime:1.4.3"
        object Compose {
            const val ui = "androidx.compose.ui:ui:1.4.3"
            const val material3 = "androidx.compose.material3:material3:1.1.0"
            const val icons  = "androidx.compose.material:material-icons-core:1.4.3"
            const val tooling  = "androidx.compose.ui:ui-tooling:1.4.3"

        }
    }

    object Other {

        object Decompose {
            private const val version = "2.0.0-beta-01"
            const val decompose = "com.arkivanov.decompose:decompose:$version"
            const val androidCompose = "com.arkivanov.decompose:extensions-compose-jetpack:$version"
            const val compose = "com.arkivanov.decompose:extensions-compose-jetbrains:$version"
        }

//        object ViewModel {
//            private const val version = "0.14"
//            const val core = "com.adeo:kviewmodel:$version"
//            const val compose = "com.adeo:kviewmodel-compose:$version"
//            const val odyssey = "com.adeo:kviewmodel-odyssey:$version"
//        }
//
//        object Navigation {
//            private const val version = "1.3.1"
//            const val core = "io.github.alexgladkov:odyssey-core:$version"
//            const val compose = "io.github.alexgladkov:odyssey-compose:$version"
//        }
    }
}