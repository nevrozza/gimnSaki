package day.old.models

sealed class HelloEvent {
    object SkipPressed: HelloEvent()
}