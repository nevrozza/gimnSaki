package theme

import SettingsRepository
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import components.theme.ThemeComponent
import components.theme.ThemeComponent.Model
import di.Inject

class ThemeComponentImpl(
    componentContext: ComponentContext,
    private val isStart: Boolean = false,
    private val onNext: () -> Unit
): ThemeComponent, ComponentContext by componentContext {
    private val _models = MutableValue(Model(isStart = this.isStart))
    override val model: Value<Model> = _models

//    val settingsRepository: SettingsRepository = Inject.instance()

    override fun onColorChangeOn(color: String) {
        _models.value = _models.value.copy(isAnimating = true)
        val settingsRepository: SettingsRepository = Inject.instance()
        settingsRepository.saveThemeColor(color)

    }

    override fun onDynamicColorChange() {
        _models.value = _models.value.copy(isDynamicAnimation = true, isAnimating = true)
        val settingsRepository: SettingsRepository = Inject.instance()
        settingsRepository.saveThemeColor(ThemeColors.Dynamic.name)
    }

    override fun onColorHasChanged() {
        _models.value = _models.value.copy(isDynamicAnimation = false, isAnimating = false)
    }

    override fun onThemeChangeOn(tint: String) {
        val settingsRepository: SettingsRepository = Inject.instance()
        settingsRepository.saveThemeColor(tint)
    }

    override fun onNextClicked() {
        onNext()
    }

}