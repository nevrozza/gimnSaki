plugins {
    id("android-setup")
    id("multiplatform-compose-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:settings:presentation"))
                implementation(project(":common:utils-compose"))
                implementation(project(":common:core"))

                implementation(Dependencies.Moko.Resources.compose)
                implementation(project(":common:utils"))


                implementation(Dependencies.Decompose.decompose)
            }
        }
    }
}