import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import components.HelloFlowComponent
import components.HelloFlowComponent.Child.StartFlowChild
import day.HelloDayComponentImpl

class HelloFlowComponentImpl(
    componentContext: ComponentContext,
    private val goMain: () -> Unit,
) : HelloFlowComponent, ComponentContext by componentContext {
    private val navigation = StackNavigation<Config>()

    private val stack = childStack(
        source = navigation,
        initialConfiguration = Config.HelloDay,
        childFactory = ::child
    )

    override val childStack: Value<ChildStack<*, HelloFlowComponent.Child>> = stack





    private fun child(config: Config, componentContext: ComponentContext): HelloFlowComponent.Child =
        when (config) {
            is Config.HelloDay -> HelloFlowComponent.Child.HelloDayChild(
                HelloDayComponentImpl(
                    componentContext,
                    goStart = { navigation.bringToFront(Config.Start) }
                )
            )

            is Config.Start -> StartFlowChild(
                StartFlowComponentImpl(
                    componentContext,
                    goMain = { goMain() }
                )
            )
        }

    @Parcelize
    private sealed interface Config : Parcelable {
        object HelloDay : Config {}
        object Start : Config {}


    }





}