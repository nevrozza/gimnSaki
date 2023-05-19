package start

import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import navigation.NavigationTree
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import splash.presentation.StartViewModel

@Composable
fun StartScreen() {
    val rootController = LocalRootController.current
//    val authRepository: AuthRepository = Inject.instance()
//    if(authRepository.fetchToken().isBlank()) {
//    rootController.push(NavigationTree.Auth.Login.name)
//    }
    StoredViewModel ( factory = { StartViewModel() } ) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()

        StartView(state = state.value) {
            viewModel.obtainEvent(it)
        }

        when (action.value) {

        }
    }
}