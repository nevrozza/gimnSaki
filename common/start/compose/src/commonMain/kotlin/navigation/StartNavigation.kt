package navigation

import ru.alexgladkov.odyssey.compose.extensions.flow
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import start.StartScreen
import start.StartView

fun RootComposeBuilder.startFlow() {
    flow(name = NavigationTree.Start.StartFlow.name) {
        screen(name = NavigationTree.Start.StartScreen.name) {
            StartScreen()
        }

        screen(name = NavigationTree.Start.StartColorScreen.name) {

        }

        screen(name = NavigationTree.Start.StartDescriptionScreen.name) {

        }

    }
//    authFlow()
}