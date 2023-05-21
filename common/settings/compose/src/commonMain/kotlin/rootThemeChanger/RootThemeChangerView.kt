package rootThemeChanger

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import theme.schemeChooser
import themeChanger.models.ThemeChangerEvent
import themeChanger.models.ThemeChangerViewState
import themeCodes.ThemeColors
import themeCodes.ThemeTint
import widgets.SegmentedButton

@Composable
fun ColorPickButton(
    buttonSize: Int,
    state: ThemeChangerViewState,
    color: String,
    isFinished: Boolean,
    animatedSize: State<Float>,
    eventHandler: (ThemeChangerEvent) -> Unit
) {
    val colorScheme = schemeChooser(true, color)



    Box(modifier = Modifier.size(buttonSize.dp + 10.dp)) {
        AnimatedVisibility(
            visible = (isFinished) || state.color == color,
            enter = fadeIn(spring(stiffness = Spring.StiffnessLow)),
            exit = fadeOut(spring(stiffness = Spring.StiffnessLow))
        ) {
            Box(contentAlignment = Alignment.Center) {
                ElevatedCard(
                    modifier = Modifier.fillMaxSize(),
                    colors = CardDefaults.outlinedCardColors(
                        containerColor = if (state.color == color) MaterialTheme.colorScheme.primaryContainer.copy(
                            alpha = 0.8f
                        ) else MaterialTheme.colorScheme.surface
                    )
                ) {}
                ElevatedButton(
                    modifier = Modifier.size(buttonSize.dp)
                        .scale(if (state.color == color) animatedSize.value else 1f)
                        .aspectRatio(1f),
                    onClick = {
                        if (isFinished) {
                            eventHandler(ThemeChangerEvent.ColorChangeOn(color))
                        }
                    },
                    colors = ButtonDefaults.outlinedButtonColors(containerColor = colorScheme.primary)
                ) {}
            }
        }

    }
}

@Composable
fun RootThemeChangerView(state: ThemeChangerViewState, eventHandler: (ThemeChangerEvent) -> Unit) {
//    val isDark: Boolean =
//        if (state.tint == ThemeTint.Auto.name) isSystemInDarkTheme()
//        else state.tint == ThemeTint.Dark.name

    BoxWithConstraints(modifier = Modifier.padding(top = 50.dp)) {
        val buttonSize = 50
        val divider = 3 * (buttonSize * buttonSize)
        val maxSize = (this.maxWidth.value * this.maxHeight.value) / divider
        val animatedSize = animateFloatAsState(
            if (state.isColorChanging) maxSize else 1f,
            animationSpec = tween(500)
        )
        if (animatedSize.value == (this.maxWidth.value * this.maxHeight.value) / divider) eventHandler(
            ThemeChangerEvent.ThemeChanged
        )

        val isFinished = !state.isColorChanging && animatedSize.value == 1f

        Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {



            Box(Modifier.fillMaxWidth().height(120.dp), contentAlignment = Alignment.TopCenter) {
                Column(
                    Modifier.matchParentSize(),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    SegmentedButton(
                        items = listOf(
                            ThemeTint.Dark.name,
                            ThemeTint.Light.name,
                            ThemeTint.Auto.name
                        ), titles = listOf("Тёмная", "Светлая", "Авто"), state.tint
                    ) {
                        eventHandler(ThemeChangerEvent.TintChangeOn(it))
                    }
                }

                Box() {
                    Row {
                        ColorPickButton(
                            buttonSize = buttonSize,
                            state = state,
                            color = ThemeColors.Default.name,
                            isFinished = isFinished,
                            animatedSize = animatedSize
                        ) {
                            eventHandler(it)
                        }
                        val remainingColors =
                            listOf(
                                ThemeColors.Green.name,
                                ThemeColors.Red.name,
                                ThemeColors.Yellow.name
                            )
                        for (color in remainingColors) {
                            Spacer(Modifier.size(10.dp))
                            ColorPickButton(
                                buttonSize = buttonSize,
                                state = state,
                                color = color,
                                isFinished = isFinished,
                                animatedSize = animatedSize
                            ) {
                                eventHandler(it)
                            }
                        }
                    }
                }
            }
        }


    }

}


