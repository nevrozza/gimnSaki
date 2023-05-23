package navigation

import com.gimnsaki.app.MR

object NavigationTree {
    enum class Splash {
        SplashScreen
    }

    enum class Start {
        StartFlow, StartScreen, StartColorScreen, StartDescriptionScreen
    }
    enum class Auth {
        AuthFlow, Login
    }
}


fun a() {
    MR.strings

}