package rootThemeChanger

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import com.gimnsaki.app.MR
import dev.icerock.moko.resources.compose.stringResource
import theme.adaptive.hpx
import theme.schemeChooser
import theme.adaptive.wpx
import themeChanger.models.ThemeChangerEvent
import themeChanger.models.ThemeChangerViewState
import themeCodes.ThemeColors
import themeCodes.ThemeTint
import widgets.AutoResizedText
import widgets.SegmentedButton

@Composable
expect fun dynamicDarkScheme(): ColorScheme?

@Composable
expect fun dynamicLightScheme(): ColorScheme?
expect fun isCanInDynamic(): Boolean


@ExperimentalMaterial3Api
@Composable
fun RootThemeChangerView(state: ThemeChangerViewState, eventHandler: (ThemeChangerEvent) -> Unit) {

    BoxWithConstraints(contentAlignment = Alignment.Center) {
        val buttonSize = 50
        val divider = 3 * (buttonSize * buttonSize)
        val maxSize = (this.maxWidth.value * this.maxHeight.value) / divider
        val animatedSize = animateFloatAsState(
            if (state.isColorChanging) maxSize else 1f,
            animationSpec = tween(500)
        )


        if (animatedSize.value == maxSize) eventHandler(ThemeChangerEvent.ThemeChanged)
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {


            ThemePreview()

            Spacer(Modifier.height(10.dp))
            ColorPickerTab(state = state, animatedSize = animatedSize, buttonSize = buttonSize) {
                eventHandler(it)
            }
        }


    }

}

@Composable
fun ThemePreview() {
    ElevatedCard(
        modifier = Modifier.size(300.wpx, 450.hpx)
    ) {

        Row() {
            Column {
                Row() {
                    Card(Modifier.size(60.wpx, 40.hpx)) {}
                    Spacer(Modifier.size(100.wpx, 40.hpx))
                    Card(Modifier.size(116.wpx, 40.hpx)) {}
                }
                Row() {
                    Column {
                        Spacer(Modifier.size(40.wpx, 100.hpx))
                        Card(Modifier.size(40.wpx, 200.hpx).padding(bottom = 3.dp)) {}
                        Card(Modifier.size(40.wpx, 150.hpx)) {}
                    }
                    Column {
                        Row {
                            //height: 85.wpx + 42.5f.hpx
                            Card(Modifier.size(150.wpx).padding(3.dp)) {}
                            Column {
                                Card(Modifier.size(85.wpx).padding(vertical = 3.dp)) {}
                                Card(Modifier.size(85.wpx, 42.5f.hpx)) {}
                            }
                        }
                        Row {
                            Card(Modifier.size(75.wpx, 120.hpx).padding(3.dp)) {}
                            Column {
                                Card(
                                    Modifier.size(75.wpx, 60.hpx).padding(top = 3.dp, end = 3.dp)
                                ) {}
                                Card(
                                    Modifier.size(75.wpx, 60.hpx)
                                        .padding(top = 3.dp, bottom = 3.dp, end = 3.dp)
                                ) {}
                            }
                            Column {
                                Card(Modifier.size(85.wpx, 90.hpx).padding(vertical = 3.dp)) {}
                            }
                        }
                        Row {
                            Column {
                                Card(
                                    Modifier.size(150.wpx, 50.hpx)
                                        .padding(start = 3.dp, bottom = 3.dp)
                                ) {}
                                Card(Modifier.size(150.wpx, 88.hpx).padding(start = 3.dp)) {}
                            }
                            Column {
                                Card(
                                    Modifier.size(85.wpx, 110.hpx)
                                        .padding(start = 3.dp, bottom = 3.dp)
                                ) {}
                                Card(Modifier.size(85.wpx, 30.hpx).padding(start = 3.dp)) {}
                            }
                        }

                    }
                }
            }
            Column(Modifier.padding(start = 3.dp)) {
                Card(Modifier.size(22.5.wpx, 210.hpx)) {}
                Spacer(Modifier.size(22.5.wpx, 40.hpx))
                Card(Modifier.size(22.5.wpx, 200.hpx)) {}
            }
        }
    }
}

@Composable
fun ColorPickButton(
    buttonSize: Int,
    state: ThemeChangerViewState,
    color: String,
    isFinished: Boolean,
    isDark: Boolean,
    animatedSize: State<Float>,
    eventHandler: (ThemeChangerEvent) -> Unit
) {


    val colorScheme = schemeChooser(!isDark, color)



    Box(modifier = Modifier.size((buttonSize + 10).hpx)) {
        AnimatedVisibility(
            visible = (isFinished) || state.color == color,
            enter = fadeIn(spring(stiffness = Spring.StiffnessLow)),
            exit = fadeOut(spring(stiffness = Spring.StiffnessLow))
        ) {
            Box(contentAlignment = Alignment.Center) {
                ElevatedCard(
                    modifier = Modifier.fillMaxSize(),
                    colors = CardDefaults.outlinedCardColors(
                        containerColor = if (state.color == color) MaterialTheme.colorScheme.secondaryContainer
                        else MaterialTheme.colorScheme.surface
                    )
                ) {}
                ElevatedButton(
                    modifier = Modifier.size(buttonSize.hpx)
                        .scale(if (state.color == color) animatedSize.value else 1f)
                        .aspectRatio(1f),
                    onClick = {
                        if (isFinished && state.color != color) {
                            eventHandler(ThemeChangerEvent.ColorChangeOn(color))
                        }
                    },
                    colors = ButtonDefaults.outlinedButtonColors(containerColor = colorScheme.primary)
                ) {}
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColorPickerTab(
    state: ThemeChangerViewState,
    animatedSize: State<Float>,
    buttonSize: Int,
    eventHandler: (ThemeChangerEvent) -> Unit
) {
    val isDark: Boolean =
        if (state.tint == ThemeTint.Auto.name) isSystemInDarkTheme()
        else state.tint == ThemeTint.Dark.name

    val isFinished = !state.isColorChanging && animatedSize.value == 1f
    val width = 290.hpx
    Column {

        Box(Modifier.height(155.hpx).width(width), contentAlignment = Alignment.TopStart) {
            Box(
                Modifier.height(155.hpx).width(width),
                contentAlignment = Alignment.BottomCenter
            ) {
                SegmentedButton(
                    minWidth = (width-16.hpx*2*3)/3f,
                    items = listOf(
                        ThemeTint.Dark.name,
                        ThemeTint.Light.name,
                        ThemeTint.Auto.name
                    ),
                    titles = listOf(
                        stringResource(MR.strings.dark_theme),
                        stringResource(MR.strings.light_theme),
                        stringResource(MR.strings.auto_theme)
                    ),
                    state.tint
                ) {
                    eventHandler(ThemeChangerEvent.TintChangeOn(it)); eventHandler(ThemeChangerEvent.ThemeChanged)
                }
            }
            Row(modifier = Modifier.width(width), horizontalArrangement = Arrangement.Center) {
                Column {
                    if (isCanInDynamic()) {
                        ElevatedCard(
                            modifier = Modifier.height(30.hpx)
                                .width(100.hpx),
                            colors = CardDefaults.elevatedCardColors(
                                containerColor = if (state.color == ThemeColors.Dynamic.name) MaterialTheme.colorScheme.secondaryContainer
                                else MaterialTheme.colorScheme.surface
                            ),
                            onClick = {
                                if (state.color != ThemeColors.Dynamic.name) eventHandler(
                                    ThemeChangerEvent.ColorChangeOn(ThemeColors.Dynamic.name)
                                )
                            }
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                AutoResizedText("Dynamic", sizer = .8f)
                            }
                        }
                        Spacer(Modifier.size(5.dp))
                    } else {
                        Spacer(Modifier.size(20.hpx+5.dp))
                    }
                    Row() {
                        ColorPickButton(
                            buttonSize = buttonSize,
                            state = state,
                            color = ThemeColors.Default.name,
                            isFinished = isFinished,
                            isDark = isDark,
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
                                isDark = isDark,
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