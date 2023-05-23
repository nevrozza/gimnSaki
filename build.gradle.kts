plugins {


//    id("com.android.application").version("7.4.0").apply(false)
//    id("com.android.library").version("7.4.0").apply(false)
//    kotlin("android").version("1.8.20").apply(false)
//    kotlin("multiplatform").version("1.8.20").apply(false)
}


buildscript {
    repositories {
        mavenCentral()
        mavenLocal()
        google()
        gradlePluginPortal()
    }

    dependencies {

        classpath(Dependencies.Moko.Resources.gradlePlugin)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
