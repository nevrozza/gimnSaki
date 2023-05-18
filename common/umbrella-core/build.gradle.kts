plugins {
    id("android-setup")
    id("multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core"))
                implementation(project(":common:utils"))
                implementation(project(":common:auth:data"))

                implementation(Dependencies.Kodein.core)
            }
        }
    }
}