package theme.adaptive

import androidx.compose.runtime.staticCompositionLocalOf

data class K(
    val w: Float,
    val h: Float
)

val LocalK = staticCompositionLocalOf<K>{
    error("No Size provided")
}