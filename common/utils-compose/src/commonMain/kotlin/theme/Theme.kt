package theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    val isDark = isSystemInDarkTheme()
    CompositionLocalProvider(
        LocalColorProvider provides if (isDark) darkPalette else lightPalette,
        content = content
    )
}

object Theme {
    val colors: GimnSakiColors
        @Composable
        get() = LocalColorProvider.current
}