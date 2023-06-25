//package theme
//
//import LocalFullScreenConstraints
//import MRStrings
//import androidx.compose.animation.AnimatedVisibility
//import androidx.compose.animation.ExperimentalAnimationApi
//import androidx.compose.animation.animateColorAsState
//import androidx.compose.animation.core.EaseIn
//import androidx.compose.animation.core.EaseOut
//import androidx.compose.animation.core.LinearEasing
//import androidx.compose.animation.core.Spring
//import androidx.compose.animation.core.animateFloatAsState
//import androidx.compose.animation.core.spring
//import androidx.compose.animation.core.tween
//import androidx.compose.animation.fadeIn
//import androidx.compose.animation.fadeOut
//import androidx.compose.animation.slideInVertically
//import androidx.compose.animation.slideOutVertically
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.aspectRatio
//import androidx.compose.foundation.layout.calculateEndPadding
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.ColorScheme
//import androidx.compose.material3.ElevatedButton
//import androidx.compose.material3.ElevatedCard
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.FilledTonalButton
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.OutlinedCard
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.State
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.scale
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.LayoutDirection
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import dev.icerock.moko.resources.compose.stringResource
//import theme.adaptive.LocalWindowScreen
//import theme.models.ThemeChangerEvent
//import theme.models.ThemeChangerViewState
//import widgets.SegmentedButton
//
//@Composable
//expect fun dynamicDarkScheme(): ColorScheme?
//
//@Composable
//expect fun dynamicLightScheme(): ColorScheme?
//expect fun isCanInDynamic(): Boolean
//
//
//@OptIn(ExperimentalAnimationApi::class)
//@ExperimentalMaterial3Api
//@Composable
//fun ThemeChangerView(
//    state: ThemeChangerViewState,
//    isStart: Boolean = false,
//    eventHandler: (ThemeChangerEvent) -> Unit
//) {
//
//    val fullScreenConstraints = LocalFullScreenConstraints.current
//    val screen = LocalWindowScreen.current
//    val buttonSize = 50
//    val divider = 3 * (buttonSize * buttonSize)
//    val maxSize =
//        (fullScreenConstraints.maxWidth.value * fullScreenConstraints.maxHeight.value) / divider
//
//    val animatedSize = animateFloatAsState(
//        if (state.isColorChanging) maxSize else 1f,
//        animationSpec = tween(500, easing = LinearEasing)
//    )
//
//
//    if (animatedSize.value == maxSize) eventHandler(ThemeChangerEvent.ColorChanged)
//
//    Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
//        when (screen) {
//            WindowScreen.Expanded -> {
//                expandedView(
//                    state = state,
//                    animatedSize = animatedSize,
//                    buttonSize = buttonSize,
//                    isStart = isStart
//                ) { eventHandler(it) }
//            }
//
//            WindowScreen.Horizontal -> horizontalView(
//                state = state,
//                animatedSize = animatedSize,
//                buttonSize = buttonSize,
//                isStart = isStart,
//                padding = padding
//            ) { eventHandler(it) }
//
//            else -> {
//                verticalView(
//                    state = state,
//                    animatedSize = animatedSize,
//                    buttonSize = buttonSize,
//                    isStart = isStart,
//                    padding = padding
//                ) { eventHandler(it) }
//            }
//        }
//    }
//}
//
//@Composable
//private fun horizontalView(
//    state: ThemeChangerViewState,
//    animatedSize: State<Float>,
//    buttonSize: Int = 50,
//    isStart: Boolean,
//    padding: PaddingValues,
//    eventHandler: (ThemeChangerEvent) -> Unit
//) {
//    Row(Modifier.padding(padding).fillMaxSize().background(MaterialTheme.colorScheme.background)) {
//        Box(
//            Modifier.padding(
//                bottom = padding.calculateBottomPadding() + padding.calculateTopPadding(),
//                top = padding.calculateTopPadding()/2,
//                start = if(padding.calculateEndPadding(LayoutDirection.Rtl) != 0.dp) padding.calculateTopPadding() else padding.calculateTopPadding()/2
//            )
//                .fillMaxHeight().fillMaxWidth(.5f)
//        ) {
//            ThemePreview()
//        }
//        Column(
//            Modifier.fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            if (isStart) {
//                Text(stringResource(MRStrings.chooseTheme),
//                    fontSize = 24.sp,
//                    modifier = Modifier.clickable { eventHandler(ThemeChangerEvent.NextPressed) })
//
//                Text(stringResource(MRStrings.chooseThemeUnder),
//                    modifier = Modifier.clickable { eventHandler(ThemeChangerEvent.NextPressed) })
//            }
//
//            Spacer(Modifier.fillMaxHeight(.05f))
//            ColorPickerTab(state = state, animatedSize = animatedSize, buttonSize = buttonSize) {
//                eventHandler(it)
//            }
//            Column(modifier = Modifier.fillMaxHeight(.7f)) {
//                AnimatedVisibility(
//                    visible = isStart && !state.isColorChanging && animatedSize.value == 1f,
//                    enter = slideInVertically(
//                        initialOffsetY = { it },
//                        animationSpec = spring(
//                            stiffness = Spring.StiffnessLow,
//                            dampingRatio = Spring.DampingRatioNoBouncy
//                        )
//                    ),
//                    exit = slideOutVertically(
//                        targetOffsetY = { it },
//                        animationSpec = spring(
//                            stiffness = Spring.StiffnessLow,
//                            dampingRatio = Spring.DampingRatioNoBouncy
//                        )
//                    ) + fadeOut(
//                        spring(
//                            stiffness = Spring.StiffnessLow,
//                            dampingRatio = Spring.DampingRatioNoBouncy
//                        )
//                    )
//                ) {
//                    Box(
//                        modifier = Modifier.fillMaxHeight(),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        FilledTonalButton(
//                            onClick = { eventHandler(ThemeChangerEvent.NextPressed) },
//                            modifier = Modifier.height(50.dp).width(150.dp)
//                        ) {
//
//                            Text("Готово!", fontSize = 19.sp)
//
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Composable
//private fun expandedView(
//    state: ThemeChangerViewState,
//    animatedSize: State<Float>,
//    buttonSize: Int,
//    isStart: Boolean,
//    eventHandler: (ThemeChangerEvent) -> Unit
//) {
//    ThemePreview()
//    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
//        OutlinedCard(
//            shape = RoundedCornerShape(
//                topStartPercent = 20,
//                topEndPercent = 20,
//                bottomStartPercent = 0,
//                bottomEndPercent = 0
//            ),
//            modifier = Modifier.width(640.dp).height(250.dp),
//            border = BorderStroke(0.dp, Color.Transparent)
//        ) {}
//        Box(modifier = Modifier.width(640.dp).height(250.dp)) {
//            Column(
//                modifier = Modifier.fillMaxSize(),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
//            ) {
//                if (isStart) {
//                    Spacer(Modifier.height(15.dp))
//                    Text(stringResource(MRStrings.chooseTheme),
//                        fontSize = 24.sp,
//                        modifier = Modifier.clickable { eventHandler(ThemeChangerEvent.NextPressed) })
//
//                    Text(stringResource(MRStrings.chooseThemeUnder),
//                        modifier = Modifier.clickable { eventHandler(ThemeChangerEvent.NextPressed) })
//                    Spacer(Modifier.height(5.dp))
//                }
//                ColorPickerTab(
//                    state = state,
//                    animatedSize = animatedSize,
//                    buttonSize = buttonSize
//                ) {
//                    eventHandler(it)
//                }
//
//            }
//            AnimatedVisibility(
//                visible = isStart && !state.isColorChanging && animatedSize.value == 1f,
//                enter = slideInVertically(
//                    initialOffsetY = { it },
//                    animationSpec = spring(
//                        stiffness = Spring.StiffnessLow,
//                        dampingRatio = Spring.DampingRatioNoBouncy
//                    )
//                ),
//                exit = slideOutVertically(
//                    targetOffsetY = { it },
//                    animationSpec = spring(
//                        stiffness = Spring.StiffnessLow,
//                        dampingRatio = Spring.DampingRatioNoBouncy
//                    )
//                ) + fadeOut(
//                    spring(
//                        stiffness = Spring.StiffnessLow,
//                        dampingRatio = Spring.DampingRatioNoBouncy
//                    )
//                )
//            ) {
//                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
//                    FilledTonalButton(
//                        onClick = { eventHandler(ThemeChangerEvent.NextPressed) },
//                        modifier = Modifier.padding(15.dp).height(40.dp).width(120.dp)
//                    ) {
//
//                        Text("Готово!")
//
//                    }
//                }
//            }
//        }
//    }
//}
//
//@ExperimentalAnimationApi
//@Composable
//private fun verticalView(
//    state: ThemeChangerViewState,
//    animatedSize: State<Float>,
//    buttonSize: Int = 50,
//    isStart: Boolean,
//    padding: PaddingValues,
//    eventHandler: (ThemeChangerEvent) -> Unit
//) {

//}
//

//

//
//@OptIn(ExperimentalMaterial3Api::class)
