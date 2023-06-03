package themeChanger

import LocalFullScreenConstraints
import theme.LocalThemeManager
import MRStrings
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.icerock.moko.resources.compose.stringResource
import theme.adaptive.LocalWindowScreen
import theme.schemeChooser
import themeChanger.models.ThemeChangerEvent
import themeChanger.models.ThemeChangerViewState
import theme.ThemeColors
import theme.ThemeTint
import widgets.SegmentedButton
import theme.WindowScreen

@Composable
expect fun dynamicDarkScheme(): ColorScheme?

@Composable
expect fun dynamicLightScheme(): ColorScheme?
expect fun isCanInDynamic(): Boolean


@OptIn(ExperimentalAnimationApi::class)
@ExperimentalMaterial3Api
@Composable
fun RootThemeChangerView(
    state: ThemeChangerViewState,
    isStart: Boolean = false,
    eventHandler: (ThemeChangerEvent) -> Unit
) {
    val themeManager = LocalThemeManager.current

    val fullScreenConstraints = LocalFullScreenConstraints.current
    val screen = LocalWindowScreen.current
    val buttonSize = 50
    val divider = 3 * (buttonSize * buttonSize)
    val maxSize =
        (fullScreenConstraints.maxWidth.value * fullScreenConstraints.maxHeight.value) / divider

    val animatedSize = animateFloatAsState(
        if (state.isColorChanging) maxSize else 1f,
        animationSpec = tween(500)
    )


    if (animatedSize.value == maxSize) eventHandler(ThemeChangerEvent.ColorChanged)

    Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
        when (screen) {
            WindowScreen.Expanded -> {
                expandedView(
                    state = state,
                    animatedSize = animatedSize,
                    buttonSize = buttonSize,
                    isStart = isStart
                ) { eventHandler(it) }
            }

            WindowScreen.Horizontal -> horizontalView(
                state = state,
                animatedSize = animatedSize,
                buttonSize = buttonSize,
                isStart = isStart,
                padding = padding
            ) { eventHandler(it) }

            else -> {
                verticalView(
                    state = state,
                    animatedSize = animatedSize,
                    buttonSize = buttonSize,
                    isStart = isStart,
                    padding = padding
                ) { eventHandler(it) }
            }
        }
    }
}

@Composable
private fun horizontalView(
    state: ThemeChangerViewState,
    animatedSize: State<Float>,
    buttonSize: Int,
    isStart: Boolean,
    padding: PaddingValues,
    eventHandler: (ThemeChangerEvent) -> Unit
) {
    Row(Modifier.padding(padding).fillMaxSize().background(MaterialTheme.colorScheme.background)) {
        Box(
            Modifier.padding(bottom = padding.calculateBottomPadding() + padding.calculateTopPadding())
                .fillMaxHeight().fillMaxWidth(.5f)
        ) {
            ThemePreview()
        }
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            if (isStart) {
                Text(stringResource(MRStrings.chooseTheme),
                    fontSize = 24.sp,
                    modifier = Modifier.clickable { eventHandler(ThemeChangerEvent.NextPressed) })

                Text(stringResource(MRStrings.chooseThemeUnder),
                    modifier = Modifier.clickable { eventHandler(ThemeChangerEvent.NextPressed) })
            }

            Spacer(Modifier.fillMaxHeight(.05f))
            ColorPickerTab(state = state, animatedSize = animatedSize, buttonSize = buttonSize) {
                eventHandler(it)
            }
            Column(modifier = Modifier.fillMaxHeight(.7f)) {
                AnimatedVisibility(
                    visible = isStart && !state.isColorChanging && animatedSize.value == 1f,
                    enter = slideInVertically(
                        initialOffsetY = { it },
                        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
                    ),
                    exit = slideOutVertically(
                        targetOffsetY = { it * 2 },
                        animationSpec = spring(stiffness = Spring.StiffnessLow)
                    )
                ) {
                    Box(
                        modifier = Modifier.fillMaxHeight(),
                        contentAlignment = Alignment.Center
                    ) {
                        FilledTonalButton(
                            onClick = { eventHandler(ThemeChangerEvent.NextPressed) },
                            modifier = Modifier.height(40.dp).width(120.dp)
                        ) {

                            Text("Готово!")

                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun expandedView(
    state: ThemeChangerViewState,
    animatedSize: State<Float>,
    buttonSize: Int,
    isStart: Boolean,
    eventHandler: (ThemeChangerEvent) -> Unit
) {
    ThemePreview()
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        OutlinedCard(
            shape = RoundedCornerShape(
                topStartPercent = 20,
                topEndPercent = 20,
                bottomStartPercent = 0,
                bottomEndPercent = 0
            ),
            modifier = Modifier.width(640.dp).height(250.dp),
            border = BorderStroke(0.dp, Color.Transparent)
        ) {}
        Box(modifier = Modifier.width(640.dp).height(250.dp)) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                if (isStart) {
                    Spacer(Modifier.height(15.dp))
                    Text(stringResource(MRStrings.chooseTheme),
                        fontSize = 24.sp,
                        modifier = Modifier.clickable { eventHandler(ThemeChangerEvent.NextPressed) })

                    Text(stringResource(MRStrings.chooseThemeUnder),
                        modifier = Modifier.clickable { eventHandler(ThemeChangerEvent.NextPressed) })
                    Spacer(Modifier.height(5.dp))
                }
                ColorPickerTab(
                    state = state,
                    animatedSize = animatedSize,
                    buttonSize = buttonSize
                ) {
                    eventHandler(it)
                }

            }
            AnimatedVisibility(
                visible = isStart && !state.isColorChanging && animatedSize.value == 1f,
                enter = slideInVertically(
                    initialOffsetY = { it },
                    animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy)
                ),
                exit = slideOutVertically(
                    targetOffsetY = { it * 2 },
                    animationSpec = spring(stiffness = Spring.StiffnessLow)
                )
            ) {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
                    FilledTonalButton(
                        onClick = { eventHandler(ThemeChangerEvent.NextPressed) },
                        modifier = Modifier.padding(15.dp).height(40.dp).width(120.dp)
                    ) {

                        Text("Готово!")

                    }
                }
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
private fun verticalView(
    state: ThemeChangerViewState,
    animatedSize: State<Float>,
    buttonSize: Int,
    isStart: Boolean,
    padding: PaddingValues,
    eventHandler: (ThemeChangerEvent) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        if (isStart) {
            Spacer(Modifier.fillMaxHeight(.01f))
            Text(stringResource(MRStrings.chooseTheme),
                fontSize = 24.sp,
                modifier = Modifier.clickable { eventHandler(ThemeChangerEvent.NextPressed) })

            Text(stringResource(MRStrings.chooseThemeUnder),
                modifier = Modifier.clickable { eventHandler(ThemeChangerEvent.NextPressed) })

            Spacer(Modifier.fillMaxHeight(.03f))
        }

        Box(Modifier.fillMaxWidth(0.77f).fillMaxHeight(0.56f)) {
            ThemePreview()
        }

        Spacer(Modifier.height(10.dp))
        ColorPickerTab(state = state, animatedSize = animatedSize, buttonSize = buttonSize) {
            eventHandler(it)
        }

        AnimatedVisibility(
            visible = isStart && !state.isColorChanging && animatedSize.value == 1f,
            enter = slideInVertically(
                initialOffsetY = { it },
                animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
            ),
            exit = slideOutVertically(
                targetOffsetY = { it * 2 },
                animationSpec = spring(stiffness = Spring.StiffnessLow)
            )
        ) {
            Box(modifier = Modifier.fillMaxHeight(.7f), contentAlignment = Alignment.Center) {
                FilledTonalButton(
                    onClick = { eventHandler(ThemeChangerEvent.NextPressed) },
                    modifier = Modifier.height(40.dp).width(120.dp)
                ) {

                    Text("Готово!")

                }
            }
        }


    }
}

@Composable
fun ThemePreview() {
    ElevatedCard(
        modifier = Modifier.fillMaxSize()
    ) {

        Row() {
            Column {
                Row() {
                    Card(Modifier.fillMaxWidth(0.2f).fillMaxHeight(0.088f), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary)) {}
                    Spacer(Modifier.fillMaxWidth(0.33f).fillMaxHeight(0.088f))
                    Card(Modifier.fillMaxWidth(0.84f).fillMaxHeight(0.088f), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)) {}
                }
                Row() {
                    Column {
                        Spacer(Modifier.fillMaxWidth(0.13f).fillMaxHeight(0.22f))
                        Card(
                            Modifier.fillMaxWidth(0.13f).fillMaxHeight(0.59f)
                                .padding(bottom = 3.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary)
                        ) {}
                        Card(
                            Modifier.fillMaxWidth(0.13f).fillMaxHeight(1f).size(40.dp, 150.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                        ) {}
                    }
                    Column {
                        Row {
                            //height: 85.wpx + 42.5f.hpx
                            Card(
                                Modifier.fillMaxWidth(0.5f).fillMaxHeight(0.33f).padding(3.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
                            ) {}
                            Column {
                                Card(
                                    Modifier.fillMaxWidth(0.8f).fillMaxHeight(0.19f)
                                        .padding(vertical = 3.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                                ) {}
                                Card(Modifier.fillMaxWidth(0.8f).fillMaxHeight(0.13f), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)) {}
                            }
                        }
                        Row {
                            Card(
                                Modifier.fillMaxWidth(0.25f).fillMaxHeight(0.45f).padding(3.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                            ) {}
                            Column {
                                Card(
                                    Modifier.fillMaxWidth(0.34f).fillMaxHeight(0.225f)
                                        .padding(top = 3.dp, end = 3.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
                                ) {}
                                Card(
                                    Modifier.fillMaxWidth(0.34f).fillMaxHeight(0.29f)
                                        .padding(top = 3.dp, bottom = 3.dp, end = 3.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
                                ) {}
                            }
                            Column {
                                Card(
                                    Modifier.fillMaxWidth(0.8f).fillMaxHeight(0.34f)
                                        .padding(vertical = 3.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
                                ) {}
                            }
                        }
                        Row {
                            Column {
                                Card(
                                    Modifier.fillMaxWidth(0.5f).fillMaxHeight(0.38f)
                                        .padding(start = 3.dp, bottom = 3.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
                                ) {}
                                Card(
                                    Modifier.fillMaxWidth(0.5f).fillMaxHeight(1f)
                                        .padding(start = 3.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
                                ) {}
                            }
                            Column {
                                Card(
                                    Modifier.fillMaxWidth(0.8f).fillMaxHeight(0.8f)
                                        .padding(start = 3.dp, bottom = 3.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                                ) {}
                                Card(
                                    Modifier.fillMaxWidth(0.8f).fillMaxHeight(1f)
                                        .padding(start = 3.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
                                ) {}
                            }
                        }

                    }
                }
            }
            Column(Modifier.padding(start = 3.dp)) {
                Card(Modifier.fillMaxWidth(1f).fillMaxHeight(0.45f), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)) {}
                Spacer(Modifier.fillMaxWidth(1f).fillMaxHeight(0.2f))
                Card(Modifier.fillMaxWidth(1f).fillMaxHeight(1f), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary)) {}
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



    Box(modifier = Modifier.size((buttonSize + 10).dp)) {
        AnimatedVisibility(
            visible = (isFinished) || state.color == color,
            enter = fadeIn(spring(stiffness = Spring.StiffnessLow)),
            exit = fadeOut(spring(stiffness = Spring.StiffnessLow))
        ) {
            Box(contentAlignment = Alignment.Center) {
                ElevatedCard(
                    modifier = Modifier.fillMaxSize(),
                    colors = CardDefaults.elevatedCardColors(
                        containerColor = if (state.color == color) MaterialTheme.colorScheme.secondaryContainer
                        else MaterialTheme.colorScheme.surface
                    )
                ) {}
                ElevatedButton(
                    modifier = Modifier.size(buttonSize.dp)
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
    val themeManager = LocalThemeManager.current
    val isDark: Boolean =
        if (state.tint == ThemeTint.Auto.name) isSystemInDarkTheme()
        else state.tint == ThemeTint.Dark.name

    val isFinished = !state.isColorChanging && animatedSize.value == 1f
    val width = 290.dp
    Column {
        Box(Modifier.height(155.dp).width(width), contentAlignment = Alignment.TopStart) {
            Box(
                Modifier.height(155.dp).width(width),
                contentAlignment = Alignment.BottomCenter
            ) {
                SegmentedButton(
                    items = listOf(
                        ThemeTint.Dark.name,
                        ThemeTint.Light.name,
                        ThemeTint.Auto.name
                    ),
                    titles = listOf(
                        stringResource(MRStrings.darkTheme),
                        stringResource(MRStrings.lightTheme),
                        stringResource(MRStrings.autoTheme)
                    ),
                    state.tint
                ) {
                    eventHandler(ThemeChangerEvent.TintChangeOn(it))
                }
            }
            Row(modifier = Modifier.width(width), horizontalArrangement = Arrangement.Center) {
                Column {
                    if (isCanInDynamic()) {
                        ElevatedCard(
                            modifier = Modifier.height(30.dp)
                                .width(100.dp),
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
                                Text("Dynamic")
                            }
                        }
                        Spacer(Modifier.size(5.dp))
                    } else {
                        Spacer(Modifier.size(20.dp + 5.dp))
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