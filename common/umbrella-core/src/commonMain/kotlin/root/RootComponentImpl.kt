package root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import HelloFlowComponentImpl
import root.RootComponent.Child

class RootComponentImpl(
    componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext {
    private val navigation = StackNavigation<Config>()
    private val stack = childStack(
        source = navigation,
        initialConfiguration = Config.Hello,
        handleBackButton = true,
        childFactory = ::child
    )
    override val childStack: Value<ChildStack<*, Child>> = stack

    private fun child(config: Config, componentContext: ComponentContext): Child =
        when (config) {
            is Config.Hello -> Child.HelloChild(
                HelloFlowComponentImpl(
                    componentContext
                ) {}
            )
        }


    private sealed interface Config : Parcelable {
        @Parcelize
        object Hello : Config
    }

}