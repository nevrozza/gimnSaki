package com.gimnsaki.app.android

import PlatformConfiguration
import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.arkivanov.decompose.defaultComponentContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import root
import root.RootComponentImpl
import setup.init


class MainActivity : AppCompatActivity() {
    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        PlatformSDK.init(
            configuration = PlatformConfiguration(applicationContext)
        )
//        setupThemedNavigation()

        WindowCompat.setDecorFitsSystemWindows(window, false)

        val windowInsetsController =
            WindowCompat.getInsetsController(window, window.decorView)
        // Configure the behavior of the hidden system bars.
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE




//        ViewCompat.getWindowInsetsController()?.isAppearanceLightStatusBars = !isDark

//        val windowInsetsController =
//            ViewCompat.getWindowInsetsController(window.decorView)

// Hide the system bars.
        windowInsetsController.hide(WindowInsetsCompat.Type.navigationBars())

        val root = RootComponentImpl(componentContext = defaultComponentContext())
        setContent {

                    root(root = root)

        }


//        init(root)
    }


}
