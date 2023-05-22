package themeChanger

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import rootThemeChanger.RootThemeChangerView
import themeChanger.models.ThemeChangerEvent
import themeChanger.models.ThemeChangerViewState

@ExperimentalMaterial3Api
@Composable
fun ThemeChangerView(
    isStart: Boolean,
    state: ThemeChangerViewState,
    eventHandler: (ThemeChangerEvent) -> Unit
) {
//    val a = remember{ mutableStateOf(false)}
//    val size = animateFloatAsState(if(state.isColorChanging) 1000f else 1f)
//    if(size.value == 1000f) eventHandler(StartColorEvent.ThemeChanged)
//    Text(size.value.toString())
//    Button(onClick = {eventHandler(StartColorEvent.ColorChangeOn("green"))}) {}


    Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
        Column(
            Modifier.fillMaxSize().padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            RootThemeChangerView(state = state) {
                eventHandler(it)
            }
            Spacer(Modifier.size(15.dp))
            Text("Выберите тему", modifier = Modifier.clickable { eventHandler(ThemeChangerEvent.NextPressed) })
            Spacer(Modifier.size(15.dp))
        }
    }
}