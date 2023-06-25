package components.theme

import com.arkivanov.decompose.value.Value
import theme.ThemeColors

interface ThemeComponent {
    val model: Value<Model>


    fun onColorChangeOn(color: String)

    fun onDynamicColorChange()

    fun onColorHasChanged()

    fun onThemeChangeOn(tint: String)
    fun onNextClicked()

    data class Model(
        val title: String = "Тема",
        val isStart: Boolean = false,
        val isAnimating: Boolean = false,
        val isDynamicAnimation: Boolean = false,
//        val color: String = ThemeColors.Default.name
    )
}