plugins {
    id("android-setup")
    id("multiplatform-setup")
    id("kotlin-parcelize")
}
dependencies {
    implementation(project(mapOf("path" to ":common:start:presentation")))
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core"))
                implementation(project(":common:auth:data"))
                implementation(project(":common:settings:data"))
                api(project(":common:start:api"))

                implementation(project(":common:start:presentation"))
                implementation(Dependencies.Decompose.decompose)
                implementation(Dependencies.Kodein.core)
            }
        }
    }
}