package com.gimnsaki.app.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import setup.setupThemedNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupThemedNavigation()
    }
}
