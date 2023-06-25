import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import components.StartFlowComponent
import components.StartFlowComponent.Child.ThemeChild
import theme.ThemeContent

@Composable
fun StartFlowContent(
    component: StartFlowComponent
) {
    val childStack by component.childStack.subscribeAsState()
    Children(
        stack = childStack,
        animation = stackAnimation(fade())
    ) {
        when (val child = it.instance) {
            is ThemeChild -> ThemeContent(child.component)
        }
    }
}