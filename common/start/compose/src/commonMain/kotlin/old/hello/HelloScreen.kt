//package old.hello
//
//import androidx.compose.runtime.Composable
//import com.adeo.kviewmodel.compose.observeAsState
//import com.adeo.kviewmodel.odyssey.StoredViewModel
//import hello.models.HelloAction
//import navigation.NavigationTree
//import ru.alexgladkov.odyssey.compose.extensions.present
//import ru.alexgladkov.odyssey.compose.local.LocalRootController
//import ru.alexgladkov.odyssey.core.LaunchFlag
//
//@Composable
//fun HelloScreen() {
//    val rootController = LocalRootController.current
//
//    StoredViewModel(factory = { HelloViewModel() }) { viewModel ->
//        val state = viewModel.viewStates().observeAsState()
//        val action = viewModel.viewActions().observeAsState()
//
//
//
//        HelloView(state = state.value) { viewModel.obtainEvent(it) }
//
//        when (action.value) {
//            is HelloAction.OpenStartColor -> rootController.present(screen = NavigationTree.Start.StartColorScreen.name, launchFlag = LaunchFlag.SingleNewTask)
//            else -> {}
//        }
//    }
//}