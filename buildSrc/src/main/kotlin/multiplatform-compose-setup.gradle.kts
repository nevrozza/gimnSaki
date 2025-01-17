import Dependencies
import dev.icerock.gradle.MRVisibility


plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("org.jetbrains.compose")

}

kotlin {
    android()
    jvm("desktop")

    sourceSets {
        named("commonMain") {
            dependencies {

                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
            }
        }

        named("desktopMain") {
            dependencies {
                implementation(compose.desktop.common)
            }
        }

        named("androidMain") {
            dependencies {
                implementation(Dependencies.Android.Compose.ui)
                implementation(Dependencies.Android.Compose.material3)
                implementation(Dependencies.Android.Compose.icons)
                implementation(Dependencies.Android.Compose.tooling)

            }
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }
}
