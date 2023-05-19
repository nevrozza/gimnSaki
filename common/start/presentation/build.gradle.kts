plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:start:api"))
                implementation(project(":common:auth:api"))
                implementation(project(":common:settings:api"))
                implementation(project(":common:core"))

                implementation(Dependencies.Kotlin.DateTime.dateTime)
                implementation(Dependencies.Other.ViewModel.core)
            }
        }
    }
}