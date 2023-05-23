import org.gradle.api.artifacts.dsl.Dependencies

plugins {
    id("com.android.library")
}

android {
    namespace = "com.gimnsaki.app.android"
    compileSdk = 33

    defaultConfig {
        targetSdk = 33
        minSdk = 21
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.4"
    }

    sourceSets {
        named("main") {
            dependencies {
                implementation("androidx.compose.runtime:runtime:1.4.3")
            }
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
        }
    }


}

