plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":common:auth:api"))
                api(project(":common:settings:api"))
                implementation(Dependencies.Decompose.decompose)
            }
        }
    }
}
