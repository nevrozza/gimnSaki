package theme

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf

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
    var color: MutableState<String>,
    var tint: MutableState<String>
)
val LocalThemeManager: ProvidableCompositionLocal<ThemeManager> = compositionLocalOf {
    error("No theme.getLocalThemeManager provided")
}