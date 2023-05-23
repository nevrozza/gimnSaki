package themeChanger

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.icerock.moko.resources.compose.stringResource
import rootThemeChanger.RootThemeChangerView
import themeChanger.models.ThemeChangerEvent
import themeChanger.models.ThemeChangerViewState
import com.gimnsaki.app.MR
import theme.adaptive.hpx
import theme.adaptive.wpx
import widgets.AutoResizedText

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
            verticalArrangement = Arrangement.Top
        ) {
            if(isStart) {
                Spacer(Modifier.height(15.dp))
                Box(Modifier.fillMaxWidth(.5f).fillMaxHeight(.05f)) {
                    AutoResizedText(
                        stringResource(MR.strings.choose_theme),
                        contentAlignment = Alignment.TopCenter,
                        fontSize = 40.sp,
                        modifier = Modifier.clickable { eventHandler(ThemeChangerEvent.NextPressed) })
                }
                Box(Modifier.fillMaxHeight(.05f)) {
                    AutoResizedText(
                        stringResource(MR.strings.choose_theme_under),
                        contentAlignment = Alignment.TopCenter,
                        fontSize = 30.sp,
                        sizer = .8f,
                        modifier = Modifier.clickable { eventHandler(ThemeChangerEvent.NextPressed) })
                }
                Spacer(Modifier.height(5.dp))
            }
            RootThemeChangerView(state = state) {
                eventHandler(it)
            }
            if(isStart) {
                Box(Modifier.fillMaxWidth().fillMaxHeight().padding(bottom = 15.hpx), contentAlignment = Alignment.Center) {
                    FilledTonalButton(
                        onClick = {eventHandler(ThemeChangerEvent.NextPressed)},
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier.height(40.hpx).width(120.wpx)
                    ) {

                        AutoResizedText("Готово!", sizer = 0.5f)

                    }
                }
            }
        }
    }
}