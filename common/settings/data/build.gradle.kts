plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:settings:api"))
                implementation(project(":common:core"))
                implementation(project(":common:utils"))

                implementation(Dependencies.Kodein.core)
                implementation(Dependencies.Settings.core)
            }
        }
    }
}