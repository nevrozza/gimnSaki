package components

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import components.day.HelloDayComponent

interface HelloFlowComponent {
    val childStack: Value<ChildStack<*, Child>>



    sealed class Child {
        class HelloDayChild(val component: HelloDayComponent) : Child()
        class StartFlowChild(val component: StartFlowComponent): Child()

    }

}