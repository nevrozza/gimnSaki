package widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import theme.adaptive.hpx

@Composable
expect fun resizedText() {}

@Composable
fun SegmentedButton(
    minWidth: Dp = 0.dp,
    items: List<String>,
    titles: List<String>,
    selected: String,
    onSelected: (String) -> Unit
) {
    Row() {
        val listOfSizes = mutableListOf<MutableState<TextUnit>>()

        for (i in items.indices) {
            val isSelected = items[i] == selected
            listOfSizes.add(mutableStateOf(40.sp))
            Box(contentAlignment = Alignment.CenterEnd) {
                OutlinedButton(
                    modifier = Modifier.height(height = 40.hpx),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if (isSelected) MaterialTheme.colorScheme.secondaryContainer else Color.Transparent,
                        contentColor = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                    ),
                    contentPadding = PaddingValues(horizontal = 24.hpx),
                    onClick = {onSelected(items [i]) },
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

                    Box (modifier = Modifier.width(minWidth), contentAlignment = Alignment.Center) {

//                        Text(text = titles[i], fontSize = 30.ssp, modifier = Modifier.offset(x = if(items[i] == items.first()) 3.dp else if(items[i] == items.last()) (-3).dp else 0.dp))
//                        AutoResizedText(text = titles[i], fontSize = listOfSizes[i], listOfSizes = listOfSizes, modifier = Modifier.offset(x = if(items[i] == items.first()) 3.dp else if(items[i] == items.last()) (-3).dp else 0.dp))
                    }
                }
                if (items[i] != items.last()) Spacer(
                    Modifier.size(1.dp, 37.8.hpx).offset(y = (-0.15).dp)
                        .background(if (isSelected) MaterialTheme.colorScheme.secondaryContainer else MaterialTheme.colorScheme.background)
                )
            }
        }
    }
}