plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.gimnsaki.app.android"
    compileSdk = 33
    defaultConfig {
        targetSdk = 33
        applicationId = "com.gimnsaki.app.android"
        minSdk = 21
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.6"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(project(":common:umbrella-compose"))
    implementation(project(":common:umbrella-core"))
    implementation(project(":common:core"))
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.compose.runtime:runtime:1.4.2")
}