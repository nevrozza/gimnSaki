plugins {
    id("android-setup")
    id("multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":common:auth:api"))
                api(project(":common:core"))
                implementation(Dependencies.Decompose.decompose)
            }
        }
    }
}