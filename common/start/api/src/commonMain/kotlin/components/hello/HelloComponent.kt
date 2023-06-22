package components.hello

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import components.start.StartComponent

interface HelloComponent {
    val childStack: Value<ChildStack<*, Child>>

    fun onSkipClicked()
    fun onMegaSkipClicked()

    sealed class Child {
        class StartChild(val component: StartComponent): Child()
        class HelloChild(val component: HelloComponent): Child()
    }


    val model: Value<Model>



    data class Model(
        val title: String = "",
        val text: String = ""
    )


}