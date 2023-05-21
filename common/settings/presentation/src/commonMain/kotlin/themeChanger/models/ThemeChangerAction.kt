package themeChanger.models

sealed class ThemeChangerAction {
    object OpenStartDescription: ThemeChangerAction()
    object UpdateTheme: ThemeChangerAction()
}
