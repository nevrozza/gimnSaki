package theme

sealed class WindowScreen {
    object Vertical : WindowScreen()
    object Horizontal : WindowScreen()
    object Expanded : WindowScreen()
}

sealed class WindowSize {
    object Compact : WindowSize()
    object Medium : WindowSize()
    object Expanded : WindowSize()
}
