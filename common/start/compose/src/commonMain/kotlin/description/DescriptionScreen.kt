package description

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import ru.alexgladkov.odyssey.compose.local.LocalRootController

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun DescriptionScreen() {
    val rootController = LocalRootController.current

    StoredViewModel(factory = { DescriptionViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()

        DescriptionView(state = state.value) { viewModel.obtainEvent(it) }

        when (action.value) {
//            is HelloAction.OpenStartColor -> rootController.present(screen = NavigationTree.Start.StartColorScreen.name, launchFlag = LaunchFlag.SingleNewTask)
//            else -> {}
        }
    }
}