package dynamic

import PlatformConfiguration
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import di.Inject

@Composable
actual fun dynamicDarkScheme(): ColorScheme? {
    val platformConfiguration: PlatformConfiguration = Inject.instance()
    return dynamicDarkColorScheme(platformConfiguration.androidContext)
}

@Composable
actual fun dynamicLightScheme(): ColorScheme? {
    val platformConfiguration: PlatformConfiguration = Inject.instance()
    return dynamicLightColorScheme(platformConfiguration.androidContext)
}