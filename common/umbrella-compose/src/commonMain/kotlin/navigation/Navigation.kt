package navigation
import SplashScreen
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder

enum class NavigationSource {
    Desktop, Android
}

fun RootComposeBuilder.generateGraph(source: NavigationSource) {


    screen(name = NavigationTree.Splash.SplashScreen.name) {
       SplashScreen()
    }

    startFlow()

    when(source) {
        NavigationSource.Android -> {}
        NavigationSource.Desktop -> {}
    }

}