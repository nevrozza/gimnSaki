plugins {
    id("android-setup")
    id("multiplatform-compose-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core"))
                api(project(":common:settings:api"))
                api(project(":common:auth:api"))

                implementation(project(":common:utils-compose"))
                implementation(project(":common:utils"))

                implementation(project(":common:auth:compose"))
//                implementation(project(":common:auth:api"))

                implementation(project(":common:start:compose"))

                implementation(Dependencies.Decompose.decompose)
            }
        }

        androidMain {
            dependencies {
                implementation(Dependencies.Android.composeActivity)
            }
        }
    }
}