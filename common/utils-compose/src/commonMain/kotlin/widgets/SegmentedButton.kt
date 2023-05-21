package widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun SegmentedButton(
    items: List<String>,
    titles: List<String>,
    selected: String,
    onSelected: (String) -> Unit
) {
    Row() {
        for (i in items.indices) {
            val isSelected = items[i] == selected
            Box(contentAlignment = Alignment.CenterEnd) {
                OutlinedButton(
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if (isSelected) MaterialTheme.colorScheme.secondaryContainer else Color.Transparent,
                        contentColor = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                    ),
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
                    Text(text = titles[i], modifier = Modifier.offset(x = if(items[i] == items.first()) 3.dp else if(items[i] == items.last()) (-3).dp else 0.dp))
                }
                if (items[i] != items.last()) Spacer(
                    Modifier.size(1.dp, 37.8.dp).offset(y = (-0.15).dp)
                        .background(if (isSelected) MaterialTheme.colorScheme.secondaryContainer else MaterialTheme.colorScheme.background)
                )
            }
        }
    }
}