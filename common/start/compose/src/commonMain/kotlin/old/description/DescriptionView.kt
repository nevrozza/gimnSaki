//@file:OptIn(ExperimentalMaterial3Api::class)
//
//package old.description
//
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.material3.ElevatedCard
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.FilledTonalButton
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import description.models.DescriptionEvent
//import description.models.DescriptionViewState
//import theme.WindowScreen
//import theme.adaptive.LocalWindowScreen
//import theme.ThemePreview
//
//@ExperimentalMaterial3Api
//@Composable
//
//fun DescriptionView(state: DescriptionViewState, eventHandler: (DescriptionEvent) -> Unit) {
//    val screen = LocalWindowScreen.current
//    Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
//        when(screen) {
//            WindowScreen.Expanded -> ExpandedView(state = state, padding = padding) { eventHandler(it) }
//            else -> VerticalView(state = state, padding = padding) { eventHandler(it) }
//        }
//
//    }
//}
//
//@Composable
//private fun ExpandedView(
//    state: DescriptionViewState,
//    padding: PaddingValues,
//    eventHandler: (DescriptionEvent) -> Unit
//) {
//    Box(modifier = Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
//        ThemePreview()
//        ElevatedCard(
//            modifier = Modifier.size(400.dp, 200.dp)
//        ) {
//            VerticalView(state = state, padding = padding) { eventHandler(it) }
//        }
//    }
//}
//
//@Composable
//private fun VerticalView(
//    state: DescriptionViewState,
//    padding: PaddingValues,
//    eventHandler: (DescriptionEvent) -> Unit
//) {
//    Column(modifier = Modifier.fillMaxSize().padding(padding), verticalArrangement = Arrangement.Center) {
//        Text("гого")
//
//        FilledTonalButton(
//            onClick = { },
//            modifier = Modifier.height(50.dp).width(150.dp)
//        ) {
//
//            Text("Далее", fontSize = 19.sp)
//
//        }
//    }
//}