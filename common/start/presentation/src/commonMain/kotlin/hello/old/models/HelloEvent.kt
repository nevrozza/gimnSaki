package hello.old.models

sealed class HelloEvent {
    object SkipPressed: HelloEvent()
}