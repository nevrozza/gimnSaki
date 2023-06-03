plugins {
    id("multiplatform-setup")
    id("android-setup")
    kotlin("native.cocoapods")
    id("dev.icerock.mobile.multiplatform-resources")
}

version = "0.0.1"

kotlin {
    cocoapods {
        summary = "GimnSaki iOS SDK"
        homepage = "https://google.com"
        ios.deploymentTarget = "14.0"

        framework {
            transitiveExport = false
            isStatic = true
            baseName = "SharedSDK"
            export(project(":common:core"))
            export(project(":common:utils"))
            export(project(":common:auth:api"))
            export(project(":common:auth:presentation"))
            export(project(":common:settings:api"))
            export(project(":common:settings:presentation"))
            export(project(":common:start:api"))
            export(project(":common:start:presentation"))
            export(project(":common:umbrella-core"))

            //MOKO
            export(Dependencies.Moko.Resources.res)
            export(Dependencies.Moko.Resources.graphics)
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core"))
                implementation(project(":common:utils"))
                implementation(project(":common:auth:api"))
                implementation(project(":common:auth:presentation"))
                implementation(project(":common:settings:api"))
                implementation(project(":common:settings:presentation"))
                implementation(project(":common:start:api"))
                implementation(project(":common:start:presentation"))
                implementation(project(":common:umbrella-core"))


                //MOKO
                implementation(Dependencies.Moko.Resources.res)
                implementation(Dependencies.Moko.Resources.graphics)
            }
        }

        iosMain {
            dependencies {
                api(project(":common:core"))
                api(project(":common:utils"))
                api(project(":common:auth:api"))
                api(project(":common:auth:presentation"))
                api(project(":common:settings:api"))
                api(project(":common:settings:presentation"))
                api(project(":common:start:api"))
                api(project(":common:start:presentation"))
                api(project(":common:umbrella-core"))


                //MOKO
                api(Dependencies.Moko.Resources.res)
                api(Dependencies.Moko.Resources.graphics)
            }
        }
    }
}