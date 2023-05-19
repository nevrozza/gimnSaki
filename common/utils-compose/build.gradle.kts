
plugins {
    id("android-setup")
    id("multiplatform-compose-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:utils"))
                implementation(Dependencies.Moko.Resources.compose)
            }
        }
    }

}
