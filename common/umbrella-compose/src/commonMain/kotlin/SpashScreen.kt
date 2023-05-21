import androidx.compose.runtime.Composable
import di.Inject
import navigation.NavigationTree

import ru.alexgladkov.odyssey.compose.extensions.present
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.core.LaunchFlag

@Composable
fun SplashScreen() {
    val rootController = LocalRootController.current
//    val authRepository: AuthRepository = Inject.instance()
//    if(authRepository.fetchToken().isBlank()) {
        rootController.present(NavigationTree.Start.StartFlow.name, launchFlag = LaunchFlag.SingleNewTask)
//    }



}