
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

        androidMain {
            dependencies {
                implementation("com.intuit.sdp:sdp-android:1.1.0")
            }
        }
    }

}
