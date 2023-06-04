package navigation

import hello.HelloScreen
import ru.alexgladkov.odyssey.compose.extensions.flow
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import themeChanger.ThemeChangerScreen

fun RootComposeBuilder.startFlow() {
    flow(name = NavigationTree.Start.StartFlow.name) {
        screen(name = NavigationTree.Start.HelloScreen.name) {
            HelloScreen()
        }

        screen(name = NavigationTree.Start.StartColorScreen.name) {
            ThemeChangerScreen(true)
        }

        screen(name = NavigationTree.Start.StartDescriptionScreen.name) {

        }

    }
//    authFlow()
}