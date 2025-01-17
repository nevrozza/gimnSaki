plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":common:settings:api"))
                implementation(project(":common:core"))

                implementation(Dependencies.Other.ViewModel.core)
            }
        }
    }
}