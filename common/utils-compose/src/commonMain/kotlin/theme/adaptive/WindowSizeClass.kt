package theme.adaptive

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import theme.WindowScreen
import theme.WindowSize
import androidx.compose.runtime.Composable


@Immutable
class WindowSizeClass private constructor(
    val width: WindowSize,
    val height: WindowSize
) {
    companion object {

        fun calculateFromSize(size: DpSize): WindowSizeClass {
            val windowWidthSizeClass = fromWidth(size.width)
            val windowHeightSizeClass = fromHeight(size.height)
            return WindowSizeClass(windowWidthSizeClass, windowHeightSizeClass)
        }
        @Composable
        fun calculateScreen(size: DpSize, device: String = "phone"): WindowScreen {
            val windowWidthSizeClass = fromWidth(size.width)
            val windowHeightSizeClass = fromHeight(size.height)
            val windowSizeClass = WindowSizeClass(windowWidthSizeClass, windowHeightSizeClass)
//            return WindowSizeClass(windowWidthSizeClass, windowHeightSizeClass)
            return if (isExpanded(windowSizeClass, device)) WindowScreen.Expanded
            else if (isVertical(windowSizeClass)) WindowScreen.Vertical
            else WindowScreen.Horizontal
        }

        private fun isHorizontal(size: WindowSizeClass): Boolean {
            return (size.height == WindowSize.Compact &&
                    (size.width == WindowSize.Expanded
                            || size.width == WindowSize.Medium))
        }

        private fun isVertical(size: WindowSizeClass): Boolean {
            return ((size.height == WindowSize.Expanded &&
                    (size.width == WindowSize.Medium
                            || size.width == WindowSize.Compact)) ||
                    (size.height == WindowSize.Medium && size.width == WindowSize.Compact)
                    )
        }
        @Composable
        private fun isExpanded(size: WindowSizeClass, device: String): Boolean {
            return ((size.width == WindowSize.Expanded &&
                    (size.height == WindowSize.Medium
                            || size.height == WindowSize.Expanded)) || (!isVertical(size) && device == "pc"))
        }
    }
}



fun fromWidth(width: Dp): WindowSize {
    require(width >= 0.dp) { "Width must not be negative" }
    return when {
        width < 600.dp -> WindowSize.Compact
        width < 840.dp -> WindowSize.Medium
        else -> WindowSize.Expanded
    }
}

//fun isHorizontal(size: WindowSizeClass): Boolean {
//    return (size.height == WindowHeight.Compact &&
//            (size.width == WindowWidth.Expanded
//                    || size.width == WindowWidth.Medium))
//}
fun fromHeight(height: Dp): WindowSize {
    require(height >= 0.dp) { "Height must not be negative" }
    return when {
        height < 480.dp -> WindowSize.Compact
        height < 900.dp -> WindowSize.Medium
        else -> WindowSize.Expanded
    }
}

