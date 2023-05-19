package theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalViewConfiguration

@Composable
actual fun AppTheme(colorScheme: ColorScheme, darkTheme: Boolean, isDynamic: Boolean, content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}

actual fun greenLightPalette(): ColorScheme = lightColorScheme()
actual fun greenDarkPalette(): ColorScheme = lightColorScheme()