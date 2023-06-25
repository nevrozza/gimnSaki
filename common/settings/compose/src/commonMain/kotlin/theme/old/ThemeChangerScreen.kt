//package theme
//
//import androidx.compose.animation.AnimatedVisibility
//import androidx.compose.animation.core.EaseIn
//import androidx.compose.animation.core.MutableTransitionState
//import androidx.compose.animation.core.tween
//import androidx.compose.animation.fadeIn
//import androidx.compose.animation.fadeOut
//import androidx.compose.foundation.background
//import androidx.compose.foundation.isSystemInDarkTheme
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Modifier
//import com.adeo.kviewmodel.compose.observeAsState
//import com.adeo.kviewmodel.odyssey.StoredViewModel
//import navigation.NavigationTree
//import ru.alexgladkov.odyssey.compose.extensions.push
//import ru.alexgladkov.odyssey.compose.local.LocalRootController
//import theme.models.ThemeChangerAction
//import theme.models.ThemeChangerEvent
//import theme.models.ThemeChangerViewState
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun ThemeChangerScreen(isStart: Boolean) {
//    val themeManager = LocalThemeManager.current
//    val rootController = LocalRootController.current
//
//    StoredViewModel(factory = { ThemeChangerViewModel(color = themeManager.color.value, tint = themeManager.tint.value) }) { viewModel ->
//        val state = viewModel.viewStates().observeAsState()
//        val action = viewModel.viewActions().observeAsState()
//        val isDynamic = isCanInDynamic() && state.value.color == ThemeColors.Dynamic.name
//        val darkColorScheme = if (isDynamic) dynamicDarkScheme()!! else schemeChooser(true, themeManager.color.value)
//        val lightColorScheme = if (isDynamic) dynamicLightScheme()!! else schemeChooser(false, themeManager.color.value)
//
//        Text(themeManager.isDark.value.toString())
//
//
//        AnimatedVisibility(
//            visible = themeManager.isDark.value,
//            enter = fadeIn(tween(500, easing = EaseIn)),
//            exit = fadeOut(tween(500, easing = EaseIn))
//        ) {
//            AppTheme(darkColorScheme) {
//                ThemeChangerView(state = state.value, isStart = isStart) {
//                    viewModel.obtainEvent(it)
//                }
//            }
//        }
//
//        AnimatedVisibility(
//            visible = !themeManager.isDark.value,
//            enter = fadeIn(tween(500, easing = EaseIn)),
//            exit = fadeOut(tween(500, easing = EaseIn))
//        ) {
//            AppTheme(lightColorScheme) {
//                ThemeChangerView(state = state.value, isStart = isStart) {
//                    viewModel.obtainEvent(it)
//                }
//            }
//        }
//
//        DynamicColorAnimation(state.value)
//
//
//        when (action.value) {
//            is ThemeChangerAction.OpenStartDescription -> {
//                rootController.push(NavigationTree.Start.StartDescriptionScreen.name);
//                viewModel.obtainEvent(ThemeChangerEvent.ActionInited)
//            }
//
//            is ThemeChangerAction.UpdateColor -> {
//                    themeManager.color.value  = state.value.color
//
//            }
//
//            is ThemeChangerAction.UpdateTint -> {
//                themeManager.tint.value  = state.value.tint
//                val isDark: Boolean =
//                    if (themeManager.tint.value == ThemeTint.Auto.name) isSystemInDarkTheme()
//                    else themeManager.tint.value == ThemeTint.Dark.name
//                themeManager.isDark.value = isDark
//            }
//
//            else -> {}
//        }
//    }
//
//
//}
//
//@Composable
//fun DynamicColorAnimation(state: ThemeChangerViewState) {
//    if (state.color == ThemeColors.Dynamic.name) {
//        val backgroundColor = dynamicDarkScheme()!!.primary
//        val stateTransition = remember {
//            MutableTransitionState(false).apply {
//                targetState = state.isColorChanging
//            }
//        }
//
//        AnimatedVisibility(
//            visibleState = stateTransition,
//            enter = fadeIn(tween(500)),
//            exit = fadeOut(tween(2000))
//        ) {
//            Box(Modifier.fillMaxSize().background(backgroundColor)) {
//                stateTransition.targetState = false
//            }
//        }
//    }
//}