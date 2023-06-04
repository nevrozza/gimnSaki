package hello

import com.adeo.kviewmodel.BaseSharedViewModel
import hello.models.HelloAction
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.IO
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.datetime.*
import hello.models.HelloEvent
import hello.models.HelloViewState


class HelloViewModel: BaseSharedViewModel<HelloViewState, HelloAction, HelloEvent>(
    initialState = HelloViewState(dataList = listOf("Здравствуйте!"))
){

    private val listOfBye = listOf("Доброй ночи!", "Геджелер хайыр!", "Доброї ночі!", "Good night!", "Gute Nacht!")
    private val listOfEvening = listOf("Добрый вечер!", "Акъшам шерфинъыз хайырлы олсун!", "Добрий вечір!", "Good evening!", "Guten Abend!")
    private val listOfAfternoon = listOf("Добрый день!", "Селям алейкум!", "Добрий день!", "Good afternoon!", "Guten Tag!")
    private val listOfMorning = listOf("Доброе утро!", "Саба шерфинъыз хъаырлы олсун!", "Доброго ранку!", "Good morning!", "Guten Morgen!")

    init {
        setDataLists()
        setText()
        startTimer()
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun obtainEvent(viewEvent: HelloEvent) {

        GlobalScope.launch(Dispatchers.IO) {
            when (viewEvent) {
                is HelloEvent.SkipPressed -> skip()
            }
        }
    }

    private fun skip() {
        viewAction = HelloAction.OpenStartColor
//        if()
//        viewAction = StartAction.OpenMainFlow
    }

    private fun setDataLists() {
        viewState = viewState.copy(dataList =
        when(viewState.hour) {
            in 5..10 -> listOfMorning
            in 11..18 -> listOfAfternoon
            in 19..21 -> listOfEvening
            else -> listOfBye
        })
    }

    private fun setText() {
        viewState = viewState.copy(text = viewState.dataList.random())
    }

    private fun startTimer() {
        var seconds = 2
        viewModelScope.launch {
            while (seconds != 0) {
                seconds--
                delay(1000)
            }

            obtainEvent(HelloEvent.SkipPressed)
//                viewModelScope.cancel()
            viewModelScope.cancel()
        }
    }
}
