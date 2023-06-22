package components.start

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import components.theme.ThemeComponent

interface StartComponent {
    val childStack: Value<ChildStack<*, Child>>

    sealed class Child {
        class ThemeChild(component: ThemeComponent): Child()
//        class DescriptionChild(component: DescriptionComponent): Child()
//        class LoginChild(component: LoginComponent): Child()
    }
}