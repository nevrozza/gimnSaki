import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import root.RootComponent
import root.RootComponent.Child.HelloChild

@Composable
fun RootContent(component: RootComponent) {
    val childStack by component.childStack.subscribeAsState()
//    val activeComponent = childStack.active.instance


        Children(
            stack = childStack,
            animation = stackAnimation(slide())
        ) {
            when (val child = it.instance) {
                is HelloChild -> HelloFlowContent(child.component)
            }
        }

}