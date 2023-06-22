package theme.models

sealed class ThemeChangerEvent {
    object NextPressed: ThemeChangerEvent()
    object ActionInited: ThemeChangerEvent()
    object ColorChanged: ThemeChangerEvent()
    data class ColorChangeOn(val color: String): ThemeChangerEvent()
    data class TintChangeOn(val tint: String): ThemeChangerEvent()
}
