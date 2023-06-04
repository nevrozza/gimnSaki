package hello.models

sealed class HelloEvent {
    object SkipPressed: HelloEvent()
}