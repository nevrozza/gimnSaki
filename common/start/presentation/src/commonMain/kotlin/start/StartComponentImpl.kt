package start

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import components.start.StartComponent
import components.start.StartComponent.Child
import components.start.StartComponent.Child.ThemeChild
import theme.ThemeComponentImpl

class StartComponentImpl(
    componentContext: ComponentContext
): StartComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()
    private val stack = childStack(
        source = navigation,
        initialConfiguration = Config.Theme,
        childFactory = ::child
    )


    override val childStack: Value<ChildStack<*, Child>>
        get() = TODO("Not yet implemented")

    private fun child(config: Config, componentContext: ComponentContext): Child =
        when(config) {
            is Config.Theme -> ThemeChild(ThemeComponentImpl(componentContext, isStart = true) {navigation.push(Config.Theme)})

        }

    @Parcelize
    private sealed interface Config: Parcelable {
        object Theme : Config
//        object Description : Config
//        object Login : Config
    }
}