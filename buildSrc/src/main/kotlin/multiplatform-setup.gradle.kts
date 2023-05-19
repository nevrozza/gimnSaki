import org.gradle.api.artifacts.dsl.Dependencies

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("dev.icerock.mobile.multiplatform-resources")
    kotlin("kapt")
}

kotlin {
    android()
    jvm("desktop")
    ios()

    dependencies {
        sourceSets {
            commonMain {
                api("dev.icerock.moko:resources:0.22.0")
            }
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }
}