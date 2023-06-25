import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import components.StartFlowComponent
import theme.ThemeComponentImpl

class StartFlowComponentImpl(
    componentContext: ComponentContext,
    private val goMain: () -> Unit
) : StartFlowComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()
    private val stack = childStack(
        source = navigation,
        initialConfiguration = Config.Theme,
        childFactory = ::child
    )

    override fun onMainClicked() {
        goMain()
    }

    override val childStack: Value<ChildStack<*, StartFlowComponent.Child>> = stack

    private fun child(config: Config, componentContext: ComponentContext): StartFlowComponent.Child =
        when (config) {
            is Config.Theme -> StartFlowComponent.Child.ThemeChild(
                ThemeComponentImpl(
                    componentContext,
                    isStart = true
                ) {  })

        }


    private sealed interface Config : Parcelable {
        @Parcelize
        object Theme : Config {}
//        object Description : Config
//        object Login : Config
    }
}