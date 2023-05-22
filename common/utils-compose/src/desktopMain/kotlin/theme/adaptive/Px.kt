package theme.adaptive

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import java.awt.Toolkit

actual val Double.hpx: Dp
    @Composable
    get() {
        val k = remember { Toolkit.getDefaultToolkit().screenSize.height/1080f }
        return (this * k).dp
    }

actual val Double.wpx: Dp
    @Composable
    get() {
        val k = remember { Toolkit.getDefaultToolkit().screenSize.width/1920f }
        return (this * k).dp
    }