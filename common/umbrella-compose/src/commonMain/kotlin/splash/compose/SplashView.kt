package splash.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import splash.presentation.models.SplashEvent
import splash.presentation.models.SplashViewState

@Composable
fun SplashView(state: SplashViewState, eventHandler: (SplashEvent) -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(state.dataList.random())
    }
}