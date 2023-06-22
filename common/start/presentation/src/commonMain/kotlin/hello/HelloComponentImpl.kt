package hello

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import components.hello.HelloComponent
import components.hello.HelloComponent.Child
import components.hello.HelloComponent.Child.HelloChild
import components.hello.HelloComponent.Child.StartChild
import components.hello.HelloComponent.Model
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import start.StartComponentImpl

class HelloComponentImpl(
    componentContext: ComponentContext,
    private val onSkip: () -> Unit,
    private val onMegaSkip: () -> Unit,
) : HelloComponent, ComponentContext by componentContext {
    private val navigation = StackNavigation<Config>()

    private val stack = childStack(
        source = navigation,
        initialConfiguration = Config.Hello,
        childFactory = ::child
    )

    override val childStack: Value<ChildStack<*, Child>> = stack

    override fun onSkipClicked() {
        onSkip()
    }

    override fun onMegaSkipClicked() {
        onMegaSkip()
    }

    private fun child(config: Config, componentContext: ComponentContext): Child =
        when (config) {
            is Config.Hello -> HelloChild(
                HelloComponentImpl(
                    componentContext,
                    onSkip,
                    onMegaSkip
                )
            )

            is Config.Start -> StartChild(StartComponentImpl(componentContext))
        }

    @Parcelize
    private sealed interface Config : Parcelable {
        object Start : Config
        object Hello : Config
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
        navigation.bringToFront(Config.Start)
    }


}