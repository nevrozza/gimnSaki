package navigation

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