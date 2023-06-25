package components

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import components.theme.ThemeComponent

interface StartFlowComponent {
    val childStack: Value<ChildStack<*, Child>>

    fun onMainClicked()

    sealed class Child {
        class ThemeChild(val component: ThemeComponent): Child()
//        class DescriptionChild(component: DescriptionComponent): Child()
//        class LoginChild(component: LoginComponent): Child()
    }
}