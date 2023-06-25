package components.day

import com.arkivanov.decompose.value.Value

interface HelloDayComponent {

    val model: Value<Model>

    fun onNextClicked()

    data class Model(
        val title: String = "",
        val text: String = ""
    )
}