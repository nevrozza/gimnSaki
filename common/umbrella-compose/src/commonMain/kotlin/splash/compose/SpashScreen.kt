import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import splash.compose.SplashView
import splash.presentation.SplashViewModel

@Composable
fun SplashScreen() {
    val rootController = LocalRootController.current

    StoredViewModel ( factory = { SplashViewModel()} ) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()

        SplashView(state = state.value) {
            viewModel.obtainEvent(it)
        }

        when (action.value) {

        }
    }
}