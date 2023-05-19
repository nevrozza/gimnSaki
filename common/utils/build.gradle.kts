plugins {
    id("dev.icerock.mobile.multiplatform-resources")
    id("android-setup")
    id("multiplatform-setup")
}

kotlin {
    dependencies {
        sourceSets {
            commonMain {
                api(Dependencies.Moko.Resources.res)
            }

        }
    }
}


multiplatformResources {
    multiplatformResourcesPackage = "com.gimnsaki.app"
    iosBaseLocalizationRegion = "ru"
}