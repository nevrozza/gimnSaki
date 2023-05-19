package splash.presentation

import com.adeo.kviewmodel.BaseSharedViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kotlinx.datetime.*
import splash.presentation.models.StartAction
import splash.presentation.models.StartEvent
import splash.presentation.models.StartViewState


class StartViewModel: BaseSharedViewModel<StartViewState, StartAction, StartEvent>(
    initialState = StartViewState(dataList = listOf("Здравствуйте!"))
){

    private val listOfBye = listOf("Доброй ночи!", "Геджелер хайыр!", "Доброї ночі!", "Good night!", "Gute Nacht!")
    private val listOfEvening = listOf("Добрый вечер!", "Акъшам шерфинъыз хайырлы олсун!", "Добрий вечір!", "Good evening!", "Guten Abend!")
    private val listOfAfternoon = listOf("Добрый день!", "Селям алейкум!", "Добрий день!", "Good afternoon!", "Guten Tag!")
    private val listOfMorning = listOf("Доброе утро!", "Саба шерфинъыз хъаырлы олсун!", "Доброго ранку!", "Good morning!", "Guten Morgen!")

    init {
        setDataLists()
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun obtainEvent(viewEvent: StartEvent) {

        GlobalScope.launch(Dispatchers.IO) {
            when (viewEvent) {

            }
        }
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
}