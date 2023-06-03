package start
import theme.LocalThemeManager
import SettingsRepository
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import di.Inject
import start.models.StartEvent
import start.models.StartViewState


@Composable
fun StartView(state: StartViewState, eventHandler: (StartEvent) -> Unit) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize().clickable {eventHandler(StartEvent.SkipPressed)}, contentAlignment = Alignment.Center) {
            Column() {
                Text(state.text)
            }
        }
    }

}