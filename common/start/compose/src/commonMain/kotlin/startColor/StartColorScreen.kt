package startColor

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import navigation.NavigationTree
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import start.StartView
import theme.AppTheme
import theme.magicForUpdateSettings
import theme.schemeChooser
import themeChanger.ThemeChangerViewModel
import themeChanger.models.ThemeChangerAction
import themeChanger.models.ThemeChangerEvent
import themeCodes.ThemeTint

@Composable
fun StartColorScreen() {
    val rootController = LocalRootController.current


    StoredViewModel(factory = { ThemeChangerViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()

        val darkColorScheme = schemeChooser(true, state.value.color)
        val lightColorScheme = schemeChooser(false, state.value.color)


        val darkTheme: Boolean =
            if (state.value.tint == ThemeTint.Auto.name) isSystemInDarkTheme()
            else state.value.tint == ThemeTint.Dark.name

        AnimatedVisibility(
            visible = darkTheme,
            enter = fadeIn(spring(stiffness = Spring.StiffnessLow)),
            exit = fadeOut(spring(stiffness = Spring.StiffnessLow))
        ) {
            AppTheme(darkColorScheme) {
                StartColorView(state = state.value) {
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
                StartColorView(state = state.value) {
                    viewModel.obtainEvent(it)
                }
            }
        }


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