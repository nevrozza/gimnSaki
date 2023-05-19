import androidx.compose.runtime.Composable
import navigation.NavigationTree

import ru.alexgladkov.odyssey.compose.extensions.present
import ru.alexgladkov.odyssey.compose.local.LocalRootController

@Composable
fun SplashScreen() {
    val rootController = LocalRootController.current
//    val authRepository: AuthRepository = Inject.instance()
//    if(authRepository.fetchToken().isBlank()) {
        rootController.findRootController().present(NavigationTree.Start.StartFlow.name)
//    }

}