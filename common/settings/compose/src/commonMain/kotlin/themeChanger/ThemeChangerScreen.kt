package themeChanger

import SettingsRepository
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import di.Inject
import navigation.NavigationTree
import rootThemeChanger.dynamicDarkScheme
import rootThemeChanger.dynamicLightScheme
import rootThemeChanger.isCanInDynamic
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import theme.AppTheme
import theme.magicForUpdateSettings
import theme.schemeChooser
import themeChanger.models.ThemeChangerAction
import themeChanger.models.ThemeChangerEvent
import themeChanger.models.ThemeChangerViewState
import themeCodes.ThemeColors
import themeCodes.ThemeTint

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThemeChangerScreen(isStart: Boolean) {
    val rootController = LocalRootController.current
    val settingsRepository = remember { mutableStateOf(Inject.instance() as SettingsRepository) }

    StoredViewModel(factory = { ThemeChangerViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()
        val isDynamic = isCanInDynamic() && state.value.color == ThemeColors.Dynamic.name
        val darkColorScheme = if (isDynamic) dynamicDarkScheme()!! else schemeChooser(true, settingsRepository.value.fetchThemeColor())
        val lightColorScheme = if (isDynamic) dynamicLightScheme()!! else schemeChooser(false, settingsRepository.value.fetchThemeColor())


        val darkTheme: Boolean =
            if (state.value.tint == ThemeTint.Auto.name) isSystemInDarkTheme()
            else state.value.tint == ThemeTint.Dark.name

        AnimatedVisibility(
            visible = darkTheme,
            enter = fadeIn(spring(stiffness = Spring.StiffnessLow)),
            exit = fadeOut(spring(stiffness = Spring.StiffnessLow))
        ) {
            AppTheme(darkColorScheme) {
                ThemeChangerView(isStart = isStart, state = state.value) {
                    viewModel.obtainEvent(it)
                }
            }
        }

        AnimatedVisibility(
            visible = !darkTheme,
            enter = fadeIn(spring(stiffness = Spring.StiffnessLow)),
            exit = fadeOut(spring(stiffness = Spring.StiffnessLow))
        ) {
            AppTheme(lightColorScheme) {
                ThemeChangerView(isStart = isStart, state = state.value) {
                    viewModel.obtainEvent(it)
                }
            }
        }

        DynamicColorAnimation(state.value)


        when (action.value) {
            is ThemeChangerAction.OpenStartDescription -> {
                rootController.push(NavigationTree.Start.StartDescriptionScreen.name);
                viewModel.obtainEvent(ThemeChangerEvent.ActionInited)
            }

            is ThemeChangerAction.UpdateTheme -> {
                magicForUpdateSettings.value = true
                viewModel.obtainEvent(ThemeChangerEvent.ActionInited)
            }

            else -> {}
        }
    }


}

@Composable
fun DynamicColorAnimation(state: ThemeChangerViewState) {
    if (state.color == ThemeColors.Dynamic.name) {
        val backgroundColor = dynamicDarkScheme()!!.primary
        val stateTransition = remember {
            MutableTransitionState(false).apply {
                targetState = state.isColorChanging
            }
        }

        AnimatedVisibility(
            visibleState = stateTransition,
            enter = fadeIn(tween(500)),
            exit = fadeOut(tween(2000))
        ) {
            Box(Modifier.fillMaxSize().background(backgroundColor)) {
                stateTransition.targetState = false
            }
        }
    }
}