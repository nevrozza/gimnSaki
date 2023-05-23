import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp

val LocalFullScreenConstraints= staticCompositionLocalOf<BoxWithConstraintsScope>  {
    error("No BoxConstraints(fullscreen) provided")
}