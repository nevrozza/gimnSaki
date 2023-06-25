import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import components.day.HelloDayComponent
import components.HelloFlowComponent
import components.HelloFlowComponent.Child.HelloDayChild
import components.HelloFlowComponent.Child.StartFlowChild
import day.HelloDayContent
import decompose.animations.verticalSlide

@Composable
fun HelloFlowContent(component: HelloFlowComponent) {
    val childStack by component.childStack.subscribeAsState()

    Children(
        stack = childStack,
        animation = stackAnimation(verticalSlide())
    ) {
        when (val child = it.instance) {
            is HelloDayChild -> HelloDayContent(child.component)
            is StartFlowChild -> StartFlowContent(child.component)
        }
    }

}