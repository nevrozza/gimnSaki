package com.gimnsaki.app.android

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import setup.setupThemedNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setupThemedNavigation()
    }
}
