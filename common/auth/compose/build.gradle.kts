plugins {
    id("android-setup")
    id("multiplatform-compose-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:auth:presentation"))
                implementation(project(":common:utils-compose"))
                implementation(project(":common:utils"))
                
                implementation(Dependencies.Decompose.decompose)
            }
        }
    }
}