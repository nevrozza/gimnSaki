package theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalViewConfiguration

@Composable
actual fun AppTheme(colorScheme: ColorScheme, darkTheme: Boolean, isDynamic: Boolean, content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalColorProvider provides colorScheme,
        content = content
    )

}