pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}



dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "gimnSaki"
include(":androidApp")

include(":common:auth:api")
include(":common:auth:compose")
include(":common:auth:data")
include(":common:auth:presentation")

include(":common:core")

include(":common:umbrella-compose")
include(":common:umbrella-core")
include(":common:umbrella-ios")

include(":common:utils")
include(":common:utils-compose")
