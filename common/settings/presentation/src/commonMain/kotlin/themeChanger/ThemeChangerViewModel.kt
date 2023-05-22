package themeChanger

import SettingsRepository
import com.adeo.kviewmodel.BaseSharedViewModel
import di.Inject
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import themeChanger.models.ThemeChangerAction
import themeChanger.models.ThemeChangerEvent
import themeChanger.models.ThemeChangerViewState

class ThemeChangerViewModel(private val settingsRepository: SettingsRepository = Inject.instance()): BaseSharedViewModel<ThemeChangerViewState, ThemeChangerAction, ThemeChangerEvent>(
    initialState = ThemeChangerViewState(color = settingsRepository.fetchThemeColor(), tint = settingsRepository.fetchThemeTint())
) {
    @OptIn(DelicateCoroutinesApi::class)
    override fun obtainEvent(viewEvent: ThemeChangerEvent) {
        GlobalScope.launch(Dispatchers.IO) {
            when (viewEvent) {
                is ThemeChangerEvent.NextPressed -> openDescription()
                is ThemeChangerEvent.ActionInited -> clearAction()
                is ThemeChangerEvent.ThemeChanged -> themeChanged()
                is ThemeChangerEvent.ColorChangeOn -> changeColorOn(viewEvent.color)
                is ThemeChangerEvent.TintChangeOn -> changeTintOn(viewEvent.tint)
            }
        }
    }

    private fun changeTintOn(tint: String) {
        viewState = viewState.copy(tint = tint)
    }

    private fun changeColorOn(color: String) {
        viewState = viewState.copy(color = color, isColorChanging = true)
    }

    private fun themeChanged() {
        settingsRepository.saveThemeTint(viewState.tint)
        settingsRepository.saveThemeColor(viewState.color)
        viewAction = ThemeChangerAction.UpdateTheme
        viewState = viewState.copy(isColorChanging = false)
    }


    private fun openDescription() {
        viewAction = ThemeChangerAction.OpenStartDescription
    }

    private fun clearAction() {

        viewAction = null
    }
}