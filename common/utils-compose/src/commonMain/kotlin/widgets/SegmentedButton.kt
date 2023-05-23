package widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

fun plusFactorial(int: Int): Int {
    return if(int == 0) 0
    else int + plusFactorial(int-1)
}

@Composable
fun SegmentedButton(
    items: List<String>,
    titles: List<String>,
    selected: String,
    onSelected: (String) -> Unit
) {
//    val style = MaterialTheme.typography.labelLarge
//    val resizedTextStyle = remember { mutableStateOf(style.copy(fontSize = 30.sp)) }


    BoxWithConstraints(
        modifier = Modifier.fillMaxWidth()
    ) {
        val widthOfAllButton = this.maxWidth
        Row(
            modifier = Modifier.offset(((-(items.size+0.10f)- plusFactorial(items.size-1)).dp)/2),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            for (i in items.indices) {
                val isSelected = items[i] == selected
                OutlinedButton(
                    modifier = Modifier.offset(
                        if(items[i] == items.first()) (items.size+0.10f).dp else (items.size-i).dp
                    ),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if (isSelected) MaterialTheme.colorScheme.secondaryContainer else Color.Transparent,
                        contentColor = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                    ),
                    contentPadding = PaddingValues(horizontal = 12.dp),
                    onClick = { onSelected(items[i]) },
                    shape = when (items[i]) {
                        items.first() -> RoundedCornerShape(
                            topStartPercent = 100,
                            bottomStartPercent = 100,
                            topEndPercent = 0,
                            bottomEndPercent = 0
                        )

                        items.last() -> RoundedCornerShape(
                            topStartPercent = 0,
                            bottomStartPercent = 0,
                            topEndPercent = 100,
                            bottomEndPercent = 100
                        )

                        else -> RoundedCornerShape(
                            topStartPercent = 0,
                            bottomStartPercent = 0,
                            topEndPercent = 0,
                            bottomEndPercent = 0
                        )
                    }
                ) {
                        Box(
                            modifier = Modifier.width(widthOfAllButton / (items.size + 1f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = titles[i],
                                modifier = Modifier.offset(x = if (items[i] == items.first()) 3.dp else if (items[i] == items.last()) (-3).dp else 0.dp),
                                maxLines = 1
////                            isCanChange = true,
//                            resizedTextStyle = resizedTextStyle,
//                            kef = 0.85f
                            )
                        }
                }

            }

        }
    }

}