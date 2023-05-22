
plugins {
    id("android-setup")
    id("multiplatform-compose-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:utils"))
                implementation("com.github.Kaaveh:sdp-compose:1.1.0")
                implementation(Dependencies.Moko.Resources.compose)
            }
        }
    }

}
