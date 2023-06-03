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

class ThemeChangerViewModel(color: String, tint: String, private val settingsRepository: SettingsRepository = Inject.instance()): BaseSharedViewModel<ThemeChangerViewState, ThemeChangerAction, ThemeChangerEvent>(
    initialState = ThemeChangerViewState(color = color, tint = tint)
) {
    @OptIn(DelicateCoroutinesApi::class)
    override fun obtainEvent(viewEvent: ThemeChangerEvent) {
        GlobalScope.launch(Dispatchers.IO) {
            when (viewEvent) {
                is ThemeChangerEvent.NextPressed -> openDescription()
                is ThemeChangerEvent.ActionInited -> clearAction()
                is ThemeChangerEvent.ColorChanged -> colorChanged()
                is ThemeChangerEvent.ColorChangeOn -> changeColorOn(viewEvent.color)
                is ThemeChangerEvent.TintChangeOn -> changeTintOn(viewEvent.tint)
            }
        }
    }

    private fun changeTintOn(tint: String) {
        viewState = viewState.copy(tint = tint)
        settingsRepository.saveThemeTint(viewState.tint)
        viewAction = ThemeChangerAction.UpdateTint
    }

    private fun changeColorOn(color: String) {
        viewState = viewState.copy(color = color, isColorChanging = true)
    }

    private fun colorChanged() {

        settingsRepository.saveThemeColor(viewState.color)
        viewAction = ThemeChangerAction.UpdateColor
        viewState = viewState.copy(isColorChanging = false)
    }


    private fun openDescription() {
        viewAction = ThemeChangerAction.OpenStartDescription
    }

    private fun clearAction() {

        viewAction = null
    }
}