import org.gradle.api.artifacts.dsl.Dependencies

plugins {
    id("com.android.library")
    kotlin("multiplatform")

    kotlin("kapt")
}

kotlin {
    android()
    jvm("desktop")
    ios()

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }
}

