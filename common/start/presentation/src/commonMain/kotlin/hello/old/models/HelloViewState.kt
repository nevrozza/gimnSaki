package hello.old.models

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime


data class HelloViewState(
    val hour: Int = Clock.System.now().toLocalDateTime(TimeZone.of("UTC+3")).hour,
    val dataList: List<String>,
    val text: String = ""
)