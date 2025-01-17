package themeChanger.models

sealed class ThemeChangerAction {
    object OpenStartDescription: ThemeChangerAction()
    object UpdateColor: ThemeChangerAction()
    object UpdateTint: ThemeChangerAction()
}
