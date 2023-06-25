@file:OptIn(ExperimentalMaterial3Api::class)

package theme

import MRStrings
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import commonLog
import components.theme.ThemeComponent
import dev.icerock.moko.resources.compose.stringResource
import dynamic.isCanInDynamic
import widgets.SegmentedButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThemeContent(
    component: ThemeComponent
) {
    val model by component.model.subscribeAsState()

    val themeManager = LocalThemeManager.current

    val buttonSize = remember { 50 }
    commonLog(themeManager.size!!.maxWidth.value .toString())
    commonLog(themeManager.size!!.maxHeight.value.toString())
    val divider = remember { 3 * (buttonSize*buttonSize) }
    commonLog(divider.toString())
    val maxSize = (themeManager.size!!.maxWidth.value * themeManager.size!!.maxHeight.value) / divider
    commonLog(maxSize.toString())
    val animatedSize = animateFloatAsState(
        if (model.isAnimating) maxSize.toFloat() else 1f,
        animationSpec = tween(500, easing = LinearEasing)
    )
    if(animatedSize.value == maxSize.toFloat()) component.onColorHasChanged()
    Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
        when (themeManager.orientation.value) {
            WindowScreen.Expanded -> {}
            WindowScreen.Horizontal -> {}
            else -> {
                VerticalView(
                    model = model,
                    animatedSize = animatedSize,
                    padding = padding,
                    onNextClicked = component.onNextClicked(),
                    tintChangeOn = {
                        component.onThemeChangeOn(tint = it)
                        themeManager.tint.value = it },
                    colorChangeOn = {
                        component.onColorChangeOn(color = it)
                        themeManager.color.value = it
                    }
                )
            }
        }
    }


}
@Composable
private fun VerticalView(
    model: ThemeComponent.Model,
    animatedSize: State<Float>,
    padding: PaddingValues,
    onNextClicked: Unit,
    tintChangeOn: (String) -> Unit,
    colorChangeOn: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        if (model.isStart) {
            Text(stringResource(MRStrings.chooseTheme),
                fontSize = 24.sp)

            Text(stringResource(MRStrings.chooseThemeUnder))

            Spacer(Modifier.fillMaxHeight(.03f))
        }

        Box(Modifier.fillMaxWidth(0.77f).fillMaxHeight(0.56f)) {
            ThemePreview()
        }

        Spacer(Modifier.height(10.dp))
        ColorPickerTab(model = model,
            animatedSize = animatedSize,
            tintChangeOn = { tintChangeOn(it) },
            colorChangeOn = { colorChangeOn(it) }
        )
        Column(modifier = Modifier.fillMaxHeight(.7f)) {
            AnimatedVisibility(
                visible = model.isStart && !model.isAnimating && animatedSize.value == 1f,
                enter = slideInVertically(
                    initialOffsetY = { it },
                    animationSpec = spring( stiffness = Spring.StiffnessLow,
                        dampingRatio = Spring.DampingRatioNoBouncy )
                ),
                exit = slideOutVertically(targetOffsetY = { it },
                    animationSpec = spring( stiffness = Spring.StiffnessLow,
                        dampingRatio = Spring.DampingRatioNoBouncy )
                ) + fadeOut(
                    spring( stiffness = Spring.StiffnessLow,
                        dampingRatio = Spring.DampingRatioNoBouncy )
                )
            ) {
                Box( modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.Center) {
                    FilledTonalButton(
                        onClick = { onNextClicked },
                        modifier = Modifier.height(50.dp).width(150.dp)
                    ) {
                        Text("Далее", fontSize = 19.sp)
                    }
                }
            }
        }


    }
}

@Composable
fun ColorPickerTab(
    model: ThemeComponent.Model,
    animatedSize: State<Float>,
    buttonSize: Int = 50,
    tintChangeOn: (String) -> Unit,
    colorChangeOn: (String) -> Unit
) {
    val themeManager = LocalThemeManager.current

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
                    themeManager.tint.value
                ) {
                    tintChangeOn(it)
                }
            }
            Row(modifier = Modifier.width(width), horizontalArrangement = Arrangement.Center) {
                Column {
                    if (isCanInDynamic()) {
                        ElevatedCard(
                            modifier = Modifier.height(30.dp)
                                .width(100.dp),
                            colors = CardDefaults.elevatedCardColors(
                                containerColor = if (themeManager.color.value == ThemeColors.Dynamic.name) MaterialTheme.colorScheme.secondaryContainer
                                else MaterialTheme.colorScheme.surface
                            ),
                            onClick = {
                                if (themeManager.color.value != ThemeColors.Dynamic.name) colorChangeOn(ThemeColors.Dynamic.name)
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
                    Row(
                        modifier = Modifier.width(width - 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        val colorsBut =
                            listOf(
                                ThemeColors.Default.name,
                                ThemeColors.Green.name,
                                ThemeColors.Red.name,
                                ThemeColors.Yellow.name
                            )
                        for (color in colorsBut) {
                            ColorPickButton(
                                model = model,
                                color = color,
                                buttonSize = buttonSize,
                                animatedSize = animatedSize
                            ) {
                                colorChangeOn(it)
                            }
                        }
                    }


                }
            }

        }
    }
}

@Composable
fun ColorPickButton(
    model: ThemeComponent.Model,
    color: String,
    buttonSize: Int = 50,
    animatedSize: State<Float>,
    colorChangeOn: (String) -> Unit
) {
    val themeManager = LocalThemeManager.current
    val lightColorScheme = schemeChooser(false, color)
    val darkColorScheme = schemeChooser(true, color)

    val animatedPrimaryColor = animateColorAsState(
        targetValue = if (themeManager.isDark.value) lightColorScheme.primary else darkColorScheme.primary,
        tween(500, easing = EaseIn)
    )


    Box(modifier = Modifier.size((buttonSize + 10).dp)) {
        AnimatedVisibility(
            visible = !model.isAnimating && animatedSize.value == 1f || themeManager.color.value == color,
            enter = fadeIn(tween(durationMillis = 200, easing = EaseIn)),
            exit = fadeOut(tween(durationMillis = 200, easing = EaseOut))
        ) {
            Box(contentAlignment = Alignment.Center) {
                ElevatedCard(
                    modifier = Modifier.fillMaxSize(),
                    colors = CardDefaults.elevatedCardColors(
                        containerColor = if (themeManager.color.value == color) MaterialTheme.colorScheme.secondaryContainer
                        else MaterialTheme.colorScheme.surface
                    )
                ) {}

                ElevatedButton(
                    modifier = Modifier.size(buttonSize.dp)
                        .scale(if (themeManager.color.value == color) animatedSize.value else 1f)
                        .aspectRatio(1f),
                    onClick = {
                        if (!model.isAnimating && themeManager.color.value != color) {
                            colorChangeOn(color)
                        }
                    },
                    colors = ButtonDefaults.outlinedButtonColors(containerColor = animatedPrimaryColor.value)
                ) {}


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
                    Card(
                        Modifier.fillMaxWidth(0.2f).fillMaxHeight(0.088f),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary)
                    ) {}
                    Spacer(Modifier.fillMaxWidth(0.33f).fillMaxHeight(0.088f))
                    Card(
                        Modifier.fillMaxWidth(0.84f).fillMaxHeight(0.088f),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
                    ) {}
                }
                Row() {
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.Bottom
                    ) {

                        Card(
                            Modifier.fillMaxWidth(0.13f).fillMaxHeight(0.50f)
                                .padding(bottom = 3.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary)
                        ) {}
                        Card(
                            Modifier.fillMaxWidth(0.13f).fillMaxHeight(0.60f),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                        ) {}
                    }
                    Column {
                        Row {
                            //height: 85.wpx + 42.5f.hpx
                            Card(
                                Modifier.fillMaxWidth(0.5f).fillMaxHeight(0.33f).padding(3.dp),
                                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
                            ) {}
                            Column {
                                Card(
                                    Modifier.fillMaxWidth(0.8f).fillMaxHeight(0.19f)
                                        .padding(vertical = 3.dp),
                                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                                ) {}
                                Card(
                                    Modifier.fillMaxWidth(0.8f).fillMaxHeight(0.13f),
                                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
                                ) {}
                            }
                        }
                        Row {
                            Card(
                                Modifier.fillMaxWidth(0.25f).fillMaxHeight(0.45f).padding(3.dp),
                                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                            ) {}
                            Column {
                                Card(
                                    Modifier.fillMaxWidth(0.34f).fillMaxHeight(0.225f)
                                        .padding(top = 3.dp, end = 3.dp),
                                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
                                ) {}
                                Card(
                                    Modifier.fillMaxWidth(0.34f).fillMaxHeight(0.29f)
                                        .padding(top = 3.dp, bottom = 3.dp, end = 3.dp),
                                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
                                ) {}
                            }
                            Card(
                                Modifier.fillMaxWidth(0.8f).fillMaxHeight(0.34f)
                                    .padding(vertical = 3.dp),
                                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
                            ) {}

                        }
                        Row {
                            Column {
                                Card(
                                    Modifier.fillMaxWidth(0.5f).fillMaxHeight(0.38f)
                                        .padding(start = 3.dp, bottom = 3.dp),
                                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
                                ) {}
                                Card(
                                    Modifier.fillMaxWidth(0.5f).fillMaxHeight(1f)
                                        .padding(start = 3.dp),
                                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
                                ) {}
                            }
                            Column {
                                Card(
                                    Modifier.fillMaxWidth(0.8f).fillMaxHeight(0.8f)
                                        .padding(start = 3.dp, bottom = 3.dp),
                                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                                ) {}
                                Card(
                                    Modifier.fillMaxWidth(0.8f).fillMaxHeight(1f)
                                        .padding(start = 3.dp),
                                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
                                ) {}
                            }
                        }

                    }
                }
            }
            Column(Modifier.padding(start = 3.dp)) {
                Card(
                    Modifier.fillMaxWidth(1f).fillMaxHeight(0.45f),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {}
                Spacer(Modifier.fillMaxWidth(1f).fillMaxHeight(0.2f))
                Card(
                    Modifier.fillMaxWidth(1f).fillMaxHeight(1f),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary)
                ) {}
            }
        }
    }
}