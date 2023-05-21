plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":common:start:api"))
                api(project(":common:auth:api"))
                api(project(":common:settings:api"))
                implementation(project(":common:core"))

                implementation(Dependencies.Kotlin.DateTime.dateTime)
                implementation(Dependencies.Other.ViewModel.core)
            }
        }
    }
}