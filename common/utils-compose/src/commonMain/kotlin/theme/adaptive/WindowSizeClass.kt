package theme.adaptive

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp


sealed class WindowScreen {
    object Vertical : WindowScreen()
    object Horizontal : WindowScreen()
    object Expanded : WindowScreen()
}

sealed class WindowWidth {
    object Compact : WindowWidth()
    object Medium : WindowWidth()
    object Expanded : WindowWidth()
}

sealed class WindowHeight {
    object Compact : WindowHeight()
    object Medium : WindowHeight()
    object Expanded : WindowHeight()
}

@Immutable
class WindowSizeClass private constructor(
    val width: WindowWidth,
    val height: WindowHeight
) {
    companion object {

        fun calculateFromSize(size: DpSize): WindowSizeClass {
            val windowWidthSizeClass = fromWidth(size.width)
            val windowHeightSizeClass = fromHeight(size.height)
            return WindowSizeClass(windowWidthSizeClass, windowHeightSizeClass)
        }

        fun calculateScreen(size: DpSize): WindowScreen {
            val windowWidthSizeClass = fromWidth(size.width)
            val windowHeightSizeClass = fromHeight(size.height)
            val windowSizeClass = WindowSizeClass(windowWidthSizeClass, windowHeightSizeClass)
//            return WindowSizeClass(windowWidthSizeClass, windowHeightSizeClass)
            return if (isExpanded(windowSizeClass)) WindowScreen.Expanded
            else if (isVertical(windowSizeClass)) WindowScreen.Vertical
            else WindowScreen.Horizontal
        }

        fun isHorizontal(size: WindowSizeClass): Boolean {
            return (size.height == WindowHeight.Compact &&
                    (size.width == WindowWidth.Expanded
                            || size.width == WindowWidth.Medium))
        }

        fun isVertical(size: WindowSizeClass): Boolean {
            return ((size.height == WindowHeight.Expanded &&
                    (size.width == WindowWidth.Medium
                            || size.width == WindowWidth.Compact)) ||
                    (size.height == WindowHeight.Medium && size.width == WindowWidth.Compact)
                    )
        }

        private fun isExpanded(size: WindowSizeClass): Boolean {
            return ((size.width == WindowWidth.Expanded &&
                    (size.height == WindowHeight.Medium
                            || size.height == WindowHeight.Expanded)))
        }
    }
}


fun fromWidth(width: Dp): WindowWidth {
    require(width >= 0.dp) { "Width must not be negative" }
    return when {
        width < 600.dp -> WindowWidth.Compact
        width < 840.dp -> WindowWidth.Medium
        else -> WindowWidth.Expanded
    }
}

//fun isHorizontal(size: WindowSizeClass): Boolean {
//    return (size.height == WindowHeight.Compact &&
//            (size.width == WindowWidth.Expanded
//                    || size.width == WindowWidth.Medium))
//}
fun fromHeight(height: Dp): WindowHeight {
    require(height >= 0.dp) { "Height must not be negative" }
    return when {
        height < 480.dp -> WindowHeight.Compact
        height < 900.dp -> WindowHeight.Medium
        else -> WindowHeight.Expanded
    }
}

