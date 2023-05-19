package theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalViewConfiguration

@Composable
expect fun AppTheme(colorScheme: ColorScheme, darkTheme: Boolean = isSystemInDarkTheme(), isDynamic: Boolean = false, content: @Composable () -> Unit)

object Theme {
    val colors: ColorScheme
        @Composable
        get() = LocalColorProvider.current
}