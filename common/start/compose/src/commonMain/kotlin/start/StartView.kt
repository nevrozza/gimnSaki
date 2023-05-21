package start
import SettingsRepository
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import di.Inject
import start.models.StartEvent
import start.models.StartViewState
import theme.magicForUpdateSettings
import themeCodes.ThemeColors
import themeCodes.ThemeTint


@Composable
fun StartView(state: StartViewState, eventHandler: (StartEvent) -> Unit) {

    val settingsRepository: SettingsRepository = Inject.instance()

    Surface(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize().clickable {eventHandler(StartEvent.SkipPressed)}, contentAlignment = Alignment.Center) {
            Column() {
                Text(state.text)

                        Button(onClick = {settingsRepository.saveThemeColor(ThemeColors.Default.name); settingsRepository.saveThemeTint(ThemeTint.Light.name); magicForUpdateSettings.value = true}) {}
                        Button(onClick = {settingsRepository.saveThemeColor(ThemeColors.Default.name); settingsRepository.saveThemeTint(ThemeTint.Dark.name); magicForUpdateSettings.value = true}) {}
                        Button(onClick = {settingsRepository.saveThemeColor(ThemeColors.Green.name); settingsRepository.saveThemeTint(ThemeTint.Light.name); magicForUpdateSettings.value = true}) {}
                        Button(onClick = {settingsRepository.saveThemeColor(ThemeColors.Green.name); settingsRepository.saveThemeTint(ThemeTint.Dark.name); magicForUpdateSettings.value = true}) {}
                        Button(onClick = {settingsRepository.saveThemeColor(ThemeColors.Red.name); settingsRepository.saveThemeTint(ThemeTint.Light.name); magicForUpdateSettings.value = true}) {}
                        Button(onClick = {settingsRepository.saveThemeColor(ThemeColors.Red.name); settingsRepository.saveThemeTint(ThemeTint.Dark.name); magicForUpdateSettings.value = true}) {}
                        Button(onClick = {settingsRepository.saveThemeColor(ThemeColors.Yellow.name); settingsRepository.saveThemeTint(ThemeTint.Light.name); magicForUpdateSettings.value = true}) {}
                        Button(onClick = {settingsRepository.saveThemeColor(ThemeColors.Yellow.name); settingsRepository.saveThemeTint(ThemeTint.Dark.name); magicForUpdateSettings.value = true}) {}
                        Button(onClick = {settingsRepository.saveThemeColor(ThemeColors.Yellow.name); settingsRepository.saveThemeTint(ThemeTint.Auto.name); magicForUpdateSettings.value = true}) {}


            }
        }
    }

}