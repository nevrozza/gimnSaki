@file:JvmName("PxKtJvm")
package theme.adaptive

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import theme.adaptive.LocalK

actual val Double.hpx: Dp
    @Composable
    get() {
        val k = LocalK.current.h
        return (this*k).dp
    }

actual val Double.wpx: Dp
    @Composable
    get() {
        val k = LocalK.current.w
        return (this*k).dp
    }