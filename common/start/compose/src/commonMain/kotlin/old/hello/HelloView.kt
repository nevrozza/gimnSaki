//package old.hello
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import hello.models.HelloEvent
//import hello.models.HelloViewState
//
//
//@Composable
//fun HelloView(state: HelloViewState, eventHandler: (HelloEvent) -> Unit) {
//    Surface(modifier = Modifier.fillMaxSize()) {
//        Box(modifier = Modifier.fillMaxSize().clickable {eventHandler(HelloEvent.SkipPressed)}, contentAlignment = Alignment.Center) {
//            Column() {
//                Text(state.text)
//            }
//        }
//    }
//
//}