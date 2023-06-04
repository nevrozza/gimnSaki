package navigation

import com.gimnsaki.app.MR

object NavigationTree {
    enum class Splash {
        SplashScreen
    }

    enum class Start {
        StartFlow, HelloScreen, StartColorScreen, StartDescriptionScreen
    }
    enum class Auth {
        AuthFlow, Login
    }
}
