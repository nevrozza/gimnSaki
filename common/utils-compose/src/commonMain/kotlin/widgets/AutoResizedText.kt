package widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

//@Composable
//expect fun AutoResizedText(text: String, modifier: Modifier, fontSize: Int)


@Composable
fun AutoResizedText(
    text: String,
    modifier: Modifier = Modifier,
    resizedTextStyle: MutableState<TextStyle> = remember { mutableStateOf(TextStyle.Default) },
    fontSize: TextUnit = 30.sp,
    kef: Float = 0.9f,
    sizer: Float = 1f,
    contentAlignment: Alignment = Alignment.Center
//    isCanChange: Boolean = false
) {
    if (resizedTextStyle.value == TextStyle.Default) resizedTextStyle.value =
        MaterialTheme.typography.labelLarge.copy(fontSize = fontSize)

    var shouldDraw by remember {
        mutableStateOf(false)
    }
//    if (isCanChange) {
    Box(
        modifier = Modifier.fillMaxSize(sizer),
        contentAlignment = contentAlignment
    ) {
        AnimatedVisibility(
            visible = shouldDraw,
            enter = fadeIn(spring(stiffness = Spring.StiffnessLow)),
            exit = fadeOut(spring(stiffness = Spring.StiffnessLow))
        ) {
            Text(
                text = text,
                modifier = modifier,
                softWrap = false,
                style = resizedTextStyle.value,
            )
        }

        Text(
            text = text,
            modifier = modifier.alpha(0f).scale(0f),
            softWrap = false,
            style = resizedTextStyle.value,
            onTextLayout = { result ->
                if (result.didOverflowWidth) {
                    resizedTextStyle.value = resizedTextStyle.value.copy(
                        fontSize = resizedTextStyle.value.fontSize * kef
                    )
                } else shouldDraw = true
            }
        )
    }
//    }

//    else {
//        Text(
//            text = text,
//            modifier = modifier,
//            softWrap = false,
//            style = resizedTextStyle.value,
//            onTextLayout = { result ->
//                if (result.didOverflowWidth) {
//                    resizedTextStyle.value = resizedTextStyle.value.copy(
//                        fontSize = resizedTextStyle.value.fontSize * kef
//                    )
//                } else shouldDraw = true
//            }
//        )
//    }


}