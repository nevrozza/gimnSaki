package theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalViewConfiguration

//Colors.kt
//val greenLightPalette: ColorScheme
//    @Composable
//    get() = greenLightPalette()

@Composable
expect fun AppTheme(colorScheme: ColorScheme, darkTheme: Boolean = isSystemInDarkTheme(), isDynamic: Boolean = false, content: @Composable () -> Unit)

expect fun greenLightPalette(): ColorScheme
expect fun greenDarkPalette(): ColorScheme