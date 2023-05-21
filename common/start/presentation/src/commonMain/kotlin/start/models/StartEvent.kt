package start.models

sealed class StartEvent {
    object SkipPressed: StartEvent()
}