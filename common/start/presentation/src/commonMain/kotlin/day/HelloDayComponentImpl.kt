package day

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import components.day.HelloDayComponent
import components.day.HelloDayComponent.Model
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class HelloDayComponentImpl(
    componentContext: ComponentContext,
    private val goStart: () -> Unit
): HelloDayComponent, ComponentContext by componentContext {
    override fun onNextClicked() {
        goStart()
    }

    private val listOfBye =
        listOf("Доброй ночи!", "Геджелер хайыр!", "Доброї ночі!", "Good night!", "Gute Nacht!")
    private val listOfEvening = listOf(
        "Добрый вечер!",
        "Акъшам шерфинъыз хайырлы олсун!",
        "Добрий вечір!",
        "Good evening!",
        "Guten Abend!"
    )
    private val listOfAfternoon =
        listOf("Добрый день!", "Селям алейкум!", "Добрий день!", "Good afternoon!", "Guten Tag!")
    private val listOfMorning = listOf(
        "Доброе утро!",
        "Саба шерфинъыз хъаырлы олсун!",
        "Доброго ранку!",
        "Good morning!",
        "Guten Morgen!"
    )

    init {
        GlobalScope.launch {
            startTimer()
        }
    }
    //    private val _models =
//        MutableValue(Model(text = getHelloText()))
    override val model: Value<Model> = MutableValue(Model(text = getHelloText()))

    private fun getHelloText(): String {
        val words =
            when (Clock.System.now().toLocalDateTime(TimeZone.of("UTC+3")).hour) {
                in 5..10 -> listOfMorning
                in 11..18 -> listOfAfternoon
                in 19..21 -> listOfEvening
                else -> listOfBye
            }
        return words.random()
    }

    private suspend fun startTimer() {
        var seconds = 2
        while (seconds != 0) {
            seconds--
            delay(1000)
        }
        CoroutineScope(Dispatchers.Main).launch {
            onNextClicked()
        }
    }

}

class PreviewHelloDayComponent: HelloDayComponent {
    override fun onNextClicked() {}
    override val model: Value<Model> = MutableValue(Model(text = "Доброй ночи!"))
}