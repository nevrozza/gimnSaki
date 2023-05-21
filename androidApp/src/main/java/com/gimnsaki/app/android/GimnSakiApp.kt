package com.gimnsaki.app.android

import PlatformConfiguration
import PlatformSDK
import android.app.Application
import android.util.Log

class GimnSakiApp: Application() {
    override fun onCreate() {
        super.onCreate()

        initPlatformSDK()
    }
}

fun GimnSakiApp.initPlatformSDK() {
    PlatformSDK.init(
        configuration = PlatformConfiguration(applicationContext)
    )
}