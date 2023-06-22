
plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}



kotlin {
    jvm {
        withJava()
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core"))
                implementation(project(":common:utils-compose"))
                implementation(project(":common:utils"))
                implementation(project(":common:auth:compose"))
                implementation(project(":common:settings:compose"))
                implementation(project(":common:start:compose"))
                implementation(project(":common:umbrella-core"))
                implementation(project(":common:umbrella-compose"))



                implementation(Dependencies.Decompose.decompose)
            }
        }

        named("jvmMain") {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "Main_desktopKt"

        nativeDistributions {
            targetFormats (
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Dmg,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Msi,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Deb
            )

            packageName = "gimnSaki"
            packageVersion = "1.0.0"
            windows {
                menuGroup = "gimnSaki"
                upgradeUuid = "134213"
            }
        }
    }
}

