package theme.adaptive

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp

expect val Double.hpx: Dp
expect val Double.wpx: Dp

val Int.hpx: Dp
    @Composable
    get() = this.toDouble().hpx

val Int.wpx: Dp
    @Composable
    get() = this.toDouble().wpx

val Float.hpx: Dp
    @Composable
    get() = this.toDouble().hpx

val Float.wpx: Dp
    @Composable
    get() = this.toDouble().wpx

