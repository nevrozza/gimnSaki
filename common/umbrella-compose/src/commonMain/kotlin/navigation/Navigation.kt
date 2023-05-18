package navigation
import SplashScreen
import navigation.NavigationTree
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder

enum class NavigationSource {
    Desktop, Android
}

fun RootComposeBuilder.generateGraph(source: NavigationSource) {

    screen(name = NavigationTree.Splash.SplashScreen.name) {
       SplashScreen()
    }

    when(source) {
        NavigationSource.Android -> {}
        NavigationSource.Desktop -> {}
    }

}