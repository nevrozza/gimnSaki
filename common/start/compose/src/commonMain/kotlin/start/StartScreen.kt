package start

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import navigation.NavigationTree
import ru.alexgladkov.odyssey.compose.extensions.present
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.core.LaunchFlag
import ru.alexgladkov.odyssey.core.animations.AnimationType
import start.models.StartAction

@Composable
fun StartScreen() {
    val rootController = LocalRootController.current

    StoredViewModel(factory = { StartViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()

        val stateTransition = remember {
            MutableTransitionState(false).apply {
                targetState = true
            }
        }

        AnimatedVisibility(visibleState = stateTransition, enter = fadeIn(spring(stiffness = Spring.StiffnessLow))) {
            StartView(state = state.value) {
                viewModel.obtainEvent(it)
            }
        }


        when (action.value) {
            is StartAction.OpenStartColor -> rootController.present(screen = NavigationTree.Start.StartColorScreen.name, launchFlag = LaunchFlag.SingleNewTask)
            else -> {}
        }
    }
}