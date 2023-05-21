package startColor

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import rootThemeChanger.RootThemeChangerView
import themeChanger.models.ThemeChangerEvent
import themeChanger.models.ThemeChangerViewState

@Composable
fun StartColorView(state: ThemeChangerViewState, eventHandler: (ThemeChangerEvent) -> Unit) {
//    val a = remember{ mutableStateOf(false)}
//    val size = animateFloatAsState(if(state.isColorChanging) 1000f else 1f)
//    if(size.value == 1000f) eventHandler(StartColorEvent.ThemeChanged)
//    Text(size.value.toString())
//    Button(onClick = {eventHandler(StartColorEvent.ColorChangeOn("green"))}) {}


    Surface(modifier = Modifier.fillMaxSize()) {
        Column {
            RootThemeChangerView(state = state) {
                eventHandler(it)
            }
        }
    }
}