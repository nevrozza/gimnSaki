package widgets

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit


@Composable
fun AutoResizedText(
    text: String,
    fontSize: MutableState<TextUnit>,
    listOfSizes: List<MutableState<TextUnit>>,
    style: TextStyle = MaterialTheme.typography.labelLarge,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified
) {
    var inited by remember {
        mutableStateOf(false)
    }


    var resizedTextStyle by remember {
        mutableStateOf(style)
    }

    if(!inited) {
        resizedTextStyle = resizedTextStyle.copy(fontSize = fontSize.value)
        inited = true
    }

    var shouldDraw by remember {
        mutableStateOf(false)
    }


    Text(
        text = text,
        color = color,
        modifier = modifier.drawWithContent {
            if (shouldDraw) drawContent()
        },
        softWrap = false,
        style = resizedTextStyle,
        onTextLayout = { result ->
            if(result.didOverflowWidth && fontSize.value == listOfSizes.) {
                fontSize.value = fontSize.value * 0.95f
                resizedTextStyle = resizedTextStyle.copy(
                    fontSize = fontSize.value
                )
            } else shouldDraw = true
        }
    )
}