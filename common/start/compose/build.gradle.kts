plugins {
    id("android-setup")
    id("multiplatform-compose-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:start:presentation"))
                implementation(project(":common:settings:compose"))
                implementation(project(":common:settings:presentation"))
                implementation(project(":common:core"))

                implementation(project(":common:utils-compose"))


                implementation(Dependencies.Moko.Resources.compose)
                implementation(project(":common:utils"))


                implementation(Dependencies.Other.ViewModel.core)
                implementation(Dependencies.Other.ViewModel.compose)
                implementation(Dependencies.Other.ViewModel.odyssey)


                implementation(Dependencies.Other.Navigation.core)
                implementation(Dependencies.Other.Navigation.compose)
            }
        }
    }
}