package root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import components.HelloFlowComponent

interface RootComponent {
    val childStack: Value<ChildStack<*, Child>>



    sealed class Child {
        class HelloChild(val component: HelloFlowComponent): Child()

    }
}