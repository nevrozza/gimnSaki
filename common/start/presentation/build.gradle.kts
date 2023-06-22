plugins {
    id("multiplatform-setup")
    id("android-setup")
    id("kotlin-parcelize")

}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":common:start:api"))
                api(project(":common:auth:api"))
                api(project(":common:settings:api"))
                implementation(project(":common:core"))
                implementation(project(":common:utils"))

                api(project(":common:settings:presentation"))
                implementation(Dependencies.Kotlin.DateTime.dateTime)
                implementation(Dependencies.Decompose.decompose)
            }
        }
    }
}