package splash.presentation

import com.adeo.kviewmodel.BaseSharedViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.datetime.*
import splash.presentation.models.SplashAction
import splash.presentation.models.SplashEvent
import splash.presentation.models.SplashViewState


class SplashViewModel: BaseSharedViewModel<SplashViewState, SplashAction, SplashEvent>(
    initialState = SplashViewState(dataList = listOf("Здравствуйте!"))
){

    private val listOfBye = listOf("Доброй ночи!", "Геджелер хайыр!", "Доброї ночі!", "Good night!", "Gute Nacht!")
    private val listOfEvening = listOf("Добрый вечер!", "Акъшам шерфинъыз хайырлы олсун!", "Добрий вечір!", "Good evening!", "Guten Abend!")
    private val listOfAfternoon = listOf("Добрый день!", "Селям алейкум!", "Добрий день!", "Good afternoon!", "Guten Tag!")
    private val listOfMorning = listOf("Доброе утро!", "Саба шерфинъыз хъаырлы олсун!", "Доброго ранку!", "Good morning!", "Guten Morgen!")

    init {
        setDataLists()
    }

    override fun obtainEvent(viewEvent: SplashEvent) {

        GlobalScope.launch(Dispatchers.IO) {
            when (viewEvent) {

            }
        }
    }

    private fun setDataLists() {
        viewState = viewState.copy(dataList = if (viewState.hour in 19..21) listOfEvening else if (viewState.hour in 5..22) listOfBye else if (viewState.hour <= 10) listOfMorning else listOfAfternoon)
    }
}