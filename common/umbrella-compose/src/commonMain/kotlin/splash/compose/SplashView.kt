package splash.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import splash.presentation.models.SplashEvent
import splash.presentation.models.SplashViewState

@ExperimentalMaterial3Api
@Composable
fun SplashView(state: SplashViewState, eventHandler: (SplashEvent) -> Unit) {
    Scaffold(modifier = Modifier.fillMaxSize()) {
         Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(state.dataList.random())
        }

    }
    Button(onClick = {}){
        Text("Sdsa")
    }
}