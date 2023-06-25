package day

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import components.day.HelloDayComponent

@Composable
fun HelloDayContent(component: HelloDayComponent) {
    val model by component.model.subscribeAsState()
    Box(modifier = Modifier.fillMaxSize().clickable {
        component.onNextClicked()
//        val newTint = if (themeManager.tint.value == ThemeTint.Dark.name) {
//            ThemeTint.Light.name
//        } else {
//            ThemeTint.Dark.name
//        }
//        themeManager.tint.value = newTint
//        commonLog("clicked")
        }, contentAlignment = Alignment.Center) {
        Text(model.text)
    }
}

//@Preview
//@Composable
//fun HelloDayPreview() {
//    hello.HelloDayContent(component = PreviewHelloDayComponent())
//}

