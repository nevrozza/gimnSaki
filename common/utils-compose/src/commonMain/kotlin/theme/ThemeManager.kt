    package theme

import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.DpSize
import theme.adaptive.WindowSizeClass

    //class ThemeManagerState(initialValue: ThemeManager) : MutableState<ThemeManager> {
//    private val state = mutableStateOf(initialValue)
//
//    override var value: ThemeManager = state.value
//
//
//    override fun component1(): ThemeManager = value
//
//    override fun component2(): (ThemeManager) -> Unit = state.component2()
//
//    fun setValue(value: ThemeManager) {
//        state.value = value
//    }
//}
class ThemeManager(
        var color: MutableState<String> = mutableStateOf(ThemeColors.Default.name),
        var tint: MutableState<String> = mutableStateOf(ThemeTint.Dark.name),
        var isDark: MutableState<Boolean> = mutableStateOf(false),
        var size: BoxWithConstraintsScope? = null,
        var orientation: MutableState<WindowScreen> = mutableStateOf(WindowScreen.Vertical)
)
val LocalThemeManager: ProvidableCompositionLocal<ThemeManager> = compositionLocalOf {
    error("No ThemeManager provided")
}