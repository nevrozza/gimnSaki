package themeChanger.models

data class ThemeChangerViewState(
    val isColorChanging: Boolean = false,
    val isTintChanging: Boolean = false,
    val color: String,
    val tint: String
)
