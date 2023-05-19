plugins {
    id("android-setup")
    id("multiplatform-compose-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core"))

                implementation(project(":common:utils-compose"))
                implementation(project(":common:utils"))

                implementation(project(":common:auth:compose"))
//                implementation(project(":common:auth:api"))

                implementation(project(":common:start:compose"))

                implementation(Dependencies.Other.ViewModel.core)
                implementation(Dependencies.Other.ViewModel.compose)
                implementation(Dependencies.Other.ViewModel.odyssey)


                implementation(Dependencies.Other.Navigation.core)
                implementation(Dependencies.Other.Navigation.compose)
            }
        }

        androidMain {
            dependencies {
                implementation(Dependencies.Android.composeActivity)
            }
        }
    }
}