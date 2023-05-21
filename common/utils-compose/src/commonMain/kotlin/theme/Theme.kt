package theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import dev.icerock.moko.resources.ColorResource
import dev.icerock.moko.resources.compose.colorResource

//Colors.kt
//val greenLightPalette: ColorScheme
//    @Composable
//    get() = greenLightPalette()

@Composable
fun AppTheme(colorScheme: ColorScheme, content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}

var magicForUpdateSettings: MutableState<Boolean> = mutableStateOf(false)

data class ColorResourcesPalette(
    val primary: ColorResource,
    val onPrimary: ColorResource,
    val primaryContainer: ColorResource,
    val onPrimaryContainer: ColorResource,
    val inversePrimary: ColorResource,
    val secondary: ColorResource,
    val onSecondary: ColorResource,
    val secondaryContainer: ColorResource,
    val onSecondaryContainer: ColorResource,
    val tertiary: ColorResource,
    val onTertiary: ColorResource,
    val tertiaryContainer: ColorResource,
    val onTertiaryContainer: ColorResource,
    val background: ColorResource,
    val onBackground: ColorResource,
    val surface: ColorResource,
    val onSurface: ColorResource,
    val surfaceVariant: ColorResource,
    val onSurfaceVariant: ColorResource,
    val surfaceTint: ColorResource,
    val inverseSurface: ColorResource,
    val inverseOnSurface: ColorResource,
    val error: ColorResource,
    val onError: ColorResource,
    val errorContainer: ColorResource,
    val onErrorContainer: ColorResource,
    val outline: ColorResource,
    val outlineVariant: ColorResource,
)
data class ColorResources(
    val defaultLight: ColorResourcesPalette,
    val defaultDark: ColorResourcesPalette,
    val greenLight: ColorResourcesPalette,
    val greenDark: ColorResourcesPalette,
    val redLight: ColorResourcesPalette,
    val redDark: ColorResourcesPalette,
    val yellowLight: ColorResourcesPalette,
    val yellowDark: ColorResourcesPalette,
)

expect val colorResources: ColorResources


@Composable
fun defaultLightPalette(): ColorScheme = ColorScheme(
    primary = colorResource(colorResources.defaultLight.primary),
    onPrimary = colorResource(colorResources.defaultLight.onPrimary),
    primaryContainer = colorResource(colorResources.defaultLight.primaryContainer),
    onPrimaryContainer = colorResource(colorResources.defaultLight.onPrimaryContainer),
    inversePrimary = colorResource(colorResources.defaultLight.inversePrimary),
    secondary = colorResource(colorResources.defaultLight.secondary),
    onSecondary = colorResource(colorResources.defaultLight.onSecondary),
    secondaryContainer = colorResource(colorResources.defaultLight.secondaryContainer),
    onSecondaryContainer = colorResource(colorResources.defaultLight.onSecondaryContainer),
    tertiary = colorResource(colorResources.defaultLight.tertiary),
    onTertiary = colorResource(colorResources.defaultLight.onTertiary),
    tertiaryContainer = colorResource(colorResources.defaultLight.tertiaryContainer),
    onTertiaryContainer = colorResource(colorResources.defaultLight.onTertiaryContainer),
    background = colorResource(colorResources.defaultLight.background),
    onBackground = colorResource(colorResources.defaultLight.onBackground),
    surface = colorResource(colorResources.defaultLight.surface),
    onSurface = colorResource(colorResources.defaultLight.onSurface),
    surfaceVariant = colorResource(colorResources.defaultLight.surfaceVariant),
    onSurfaceVariant = colorResource(colorResources.defaultLight.onSurfaceVariant),
    surfaceTint = colorResource(colorResources.defaultLight.surfaceTint),
    inverseSurface = colorResource(colorResources.defaultLight.inverseSurface),
    inverseOnSurface = colorResource(colorResources.defaultLight.inverseOnSurface),
    error = colorResource(colorResources.defaultLight.error),
    onError = colorResource(colorResources.defaultLight.onError),
    errorContainer = colorResource(colorResources.defaultLight.errorContainer),
    onErrorContainer = colorResource(colorResources.defaultLight.onErrorContainer),
    outline = colorResource(colorResources.defaultLight.outline),
    outlineVariant = colorResource(colorResources.defaultLight.outlineVariant),
    scrim = Color.Black
)
@Composable
fun defaultDarkPalette(): ColorScheme = ColorScheme(
    primary = colorResource(colorResources.defaultDark.primary),
    onPrimary = colorResource(colorResources.defaultDark.onPrimary),
    primaryContainer = colorResource(colorResources.defaultDark.primaryContainer),
    onPrimaryContainer = colorResource(colorResources.defaultDark.onPrimaryContainer),
    inversePrimary = colorResource(colorResources.defaultDark.inversePrimary),
    secondary = colorResource(colorResources.defaultDark.secondary),
    onSecondary = colorResource(colorResources.defaultDark.onSecondary),
    secondaryContainer = colorResource(colorResources.defaultDark.secondaryContainer),
    onSecondaryContainer = colorResource(colorResources.defaultDark.onSecondaryContainer),
    tertiary = colorResource(colorResources.defaultDark.tertiary),
    onTertiary = colorResource(colorResources.defaultDark.onTertiary),
    tertiaryContainer = colorResource(colorResources.defaultDark.tertiaryContainer),
    onTertiaryContainer = colorResource(colorResources.defaultDark.onTertiaryContainer),
    background = colorResource(colorResources.defaultDark.background),
    onBackground = colorResource(colorResources.defaultDark.onBackground),
    surface = colorResource(colorResources.defaultDark.surface),
    onSurface = colorResource(colorResources.defaultDark.onSurface),
    surfaceVariant = colorResource(colorResources.defaultDark.surfaceVariant),
    onSurfaceVariant = colorResource(colorResources.defaultDark.onSurfaceVariant),
    surfaceTint = colorResource(colorResources.defaultDark.surfaceTint),
    inverseSurface = colorResource(colorResources.defaultDark.inverseSurface),
    inverseOnSurface = colorResource(colorResources.defaultDark.inverseOnSurface),
    error = colorResource(colorResources.defaultDark.error),
    onError = colorResource(colorResources.defaultDark.onError),
    errorContainer = colorResource(colorResources.defaultDark.errorContainer),
    onErrorContainer = colorResource(colorResources.defaultDark.onErrorContainer),
    outline = colorResource(colorResources.defaultDark.outline),
    outlineVariant = colorResource(colorResources.defaultDark.outlineVariant),
    scrim = Color.Black
)

@Composable
fun greenLightPalette(): ColorScheme = ColorScheme(
    primary = colorResource(colorResources.greenLight.primary),
    onPrimary = colorResource(colorResources.greenLight.onPrimary),
    primaryContainer = colorResource(colorResources.greenLight.primaryContainer),
    onPrimaryContainer = colorResource(colorResources.greenLight.onPrimaryContainer),
    inversePrimary = colorResource(colorResources.greenLight.inversePrimary),
    secondary = colorResource(colorResources.greenLight.secondary),
    onSecondary = colorResource(colorResources.greenLight.onSecondary),
    secondaryContainer = colorResource(colorResources.greenLight.secondaryContainer),
    onSecondaryContainer = colorResource(colorResources.greenLight.onSecondaryContainer),
    tertiary = colorResource(colorResources.greenLight.tertiary),
    onTertiary = colorResource(colorResources.greenLight.onTertiary),
    tertiaryContainer = colorResource(colorResources.greenLight.tertiaryContainer),
    onTertiaryContainer = colorResource(colorResources.greenLight.onTertiaryContainer),
    background = colorResource(colorResources.greenLight.background),
    onBackground = colorResource(colorResources.greenLight.onBackground),
    surface = colorResource(colorResources.greenLight.surface),
    onSurface = colorResource(colorResources.greenLight.onSurface),
    surfaceVariant = colorResource(colorResources.greenLight.surfaceVariant),
    onSurfaceVariant = colorResource(colorResources.greenLight.onSurfaceVariant),
    surfaceTint = colorResource(colorResources.greenLight.surfaceTint),
    inverseSurface = colorResource(colorResources.greenLight.inverseSurface),
    inverseOnSurface = colorResource(colorResources.greenLight.inverseOnSurface),
    error = colorResource(colorResources.greenLight.error),
    onError = colorResource(colorResources.greenLight.onError),
    errorContainer = colorResource(colorResources.greenLight.errorContainer),
    onErrorContainer = colorResource(colorResources.greenLight.onErrorContainer),
    outline = colorResource(colorResources.greenLight.outline),
    outlineVariant = colorResource(colorResources.greenLight.outlineVariant),
    scrim = Color.Black
)
@Composable
fun greenDarkPalette(): ColorScheme = ColorScheme(
    primary = colorResource(colorResources.greenDark.primary),
    onPrimary = colorResource(colorResources.greenDark.onPrimary),
    primaryContainer = colorResource(colorResources.greenDark.primaryContainer),
    onPrimaryContainer = colorResource(colorResources.greenDark.onPrimaryContainer),
    inversePrimary = colorResource(colorResources.greenDark.inversePrimary),
    secondary = colorResource(colorResources.greenDark.secondary),
    onSecondary = colorResource(colorResources.greenDark.onSecondary),
    secondaryContainer = colorResource(colorResources.greenDark.secondaryContainer),
    onSecondaryContainer = colorResource(colorResources.greenDark.onSecondaryContainer),
    tertiary = colorResource(colorResources.greenDark.tertiary),
    onTertiary = colorResource(colorResources.greenDark.onTertiary),
    tertiaryContainer = colorResource(colorResources.greenDark.tertiaryContainer),
    onTertiaryContainer = colorResource(colorResources.greenDark.onTertiaryContainer),
    background = colorResource(colorResources.greenDark.background),
    onBackground = colorResource(colorResources.greenDark.onBackground),
    surface = colorResource(colorResources.greenDark.surface),
    onSurface = colorResource(colorResources.greenDark.onSurface),
    surfaceVariant = colorResource(colorResources.greenDark.surfaceVariant),
    onSurfaceVariant = colorResource(colorResources.greenDark.onSurfaceVariant),
    surfaceTint = colorResource(colorResources.greenDark.surfaceTint),
    inverseSurface = colorResource(colorResources.greenDark.inverseSurface),
    inverseOnSurface = colorResource(colorResources.greenDark.inverseOnSurface),
    error = colorResource(colorResources.greenDark.error),
    onError = colorResource(colorResources.greenDark.onError),
    errorContainer = colorResource(colorResources.greenDark.errorContainer),
    onErrorContainer = colorResource(colorResources.greenDark.onErrorContainer),
    outline = colorResource(colorResources.greenDark.outline),
    outlineVariant = colorResource(colorResources.greenDark.outlineVariant),
    scrim = Color.Black
)

@Composable
fun redLightPalette(): ColorScheme = ColorScheme(
    primary = colorResource(colorResources.redLight.primary),
    onPrimary = colorResource(colorResources.redLight.onPrimary),
    primaryContainer = colorResource(colorResources.redLight.primaryContainer),
    onPrimaryContainer = colorResource(colorResources.redLight.onPrimaryContainer),
    inversePrimary = colorResource(colorResources.redLight.inversePrimary),
    secondary = colorResource(colorResources.redLight.secondary),
    onSecondary = colorResource(colorResources.redLight.onSecondary),
    secondaryContainer = colorResource(colorResources.redLight.secondaryContainer),
    onSecondaryContainer = colorResource(colorResources.redLight.onSecondaryContainer),
    tertiary = colorResource(colorResources.redLight.tertiary),
    onTertiary = colorResource(colorResources.redLight.onTertiary),
    tertiaryContainer = colorResource(colorResources.redLight.tertiaryContainer),
    onTertiaryContainer = colorResource(colorResources.redLight.onTertiaryContainer),
    background = colorResource(colorResources.redLight.background),
    onBackground = colorResource(colorResources.redLight.onBackground),
    surface = colorResource(colorResources.redLight.surface),
    onSurface = colorResource(colorResources.redLight.onSurface),
    surfaceVariant = colorResource(colorResources.redLight.surfaceVariant),
    onSurfaceVariant = colorResource(colorResources.redLight.onSurfaceVariant),
    surfaceTint = colorResource(colorResources.redLight.surfaceTint),
    inverseSurface = colorResource(colorResources.redLight.inverseSurface),
    inverseOnSurface = colorResource(colorResources.redLight.inverseOnSurface),
    error = colorResource(colorResources.redLight.error),
    onError = colorResource(colorResources.redLight.onError),
    errorContainer = colorResource(colorResources.redLight.errorContainer),
    onErrorContainer = colorResource(colorResources.redLight.onErrorContainer),
    outline = colorResource(colorResources.redLight.outline),
    outlineVariant = colorResource(colorResources.redLight.outlineVariant),
    scrim = Color.Black
)
@Composable
fun redDarkPalette(): ColorScheme = ColorScheme(
    primary = colorResource(colorResources.redDark.primary),
    onPrimary = colorResource(colorResources.redDark.onPrimary),
    primaryContainer = colorResource(colorResources.redDark.primaryContainer),
    onPrimaryContainer = colorResource(colorResources.redDark.onPrimaryContainer),
    inversePrimary = colorResource(colorResources.redDark.inversePrimary),
    secondary = colorResource(colorResources.redDark.secondary),
    onSecondary = colorResource(colorResources.redDark.onSecondary),
    secondaryContainer = colorResource(colorResources.redDark.secondaryContainer),
    onSecondaryContainer = colorResource(colorResources.redDark.onSecondaryContainer),
    tertiary = colorResource(colorResources.redDark.tertiary),
    onTertiary = colorResource(colorResources.redDark.onTertiary),
    tertiaryContainer = colorResource(colorResources.redDark.tertiaryContainer),
    onTertiaryContainer = colorResource(colorResources.redDark.onTertiaryContainer),
    background = colorResource(colorResources.redDark.background),
    onBackground = colorResource(colorResources.redDark.onBackground),
    surface = colorResource(colorResources.redDark.surface),
    onSurface = colorResource(colorResources.redDark.onSurface),
    surfaceVariant = colorResource(colorResources.redDark.surfaceVariant),
    onSurfaceVariant = colorResource(colorResources.redDark.onSurfaceVariant),
    surfaceTint = colorResource(colorResources.redDark.surfaceTint),
    inverseSurface = colorResource(colorResources.redDark.inverseSurface),
    inverseOnSurface = colorResource(colorResources.redDark.inverseOnSurface),
    error = colorResource(colorResources.redDark.error),
    onError = colorResource(colorResources.redDark.onError),
    errorContainer = colorResource(colorResources.redDark.errorContainer),
    onErrorContainer = colorResource(colorResources.redDark.onErrorContainer),
    outline = colorResource(colorResources.redDark.outline),
    outlineVariant = colorResource(colorResources.redDark.outlineVariant),
    scrim = Color.Black
)

@Composable
fun yellowLightPalette(): ColorScheme = ColorScheme(
    primary = colorResource(colorResources.yellowLight.primary),
    onPrimary = colorResource(colorResources.yellowLight.onPrimary),
    primaryContainer = colorResource(colorResources.yellowLight.primaryContainer),
    onPrimaryContainer = colorResource(colorResources.yellowLight.onPrimaryContainer),
    inversePrimary = colorResource(colorResources.yellowLight.inversePrimary),
    secondary = colorResource(colorResources.yellowLight.secondary),
    onSecondary = colorResource(colorResources.yellowLight.onSecondary),
    secondaryContainer = colorResource(colorResources.yellowLight.secondaryContainer),
    onSecondaryContainer = colorResource(colorResources.yellowLight.onSecondaryContainer),
    tertiary = colorResource(colorResources.yellowLight.tertiary),
    onTertiary = colorResource(colorResources.yellowLight.onTertiary),
    tertiaryContainer = colorResource(colorResources.yellowLight.tertiaryContainer),
    onTertiaryContainer = colorResource(colorResources.yellowLight.onTertiaryContainer),
    background = colorResource(colorResources.yellowLight.background),
    onBackground = colorResource(colorResources.yellowLight.onBackground),
    surface = colorResource(colorResources.yellowLight.surface),
    onSurface = colorResource(colorResources.yellowLight.onSurface),
    surfaceVariant = colorResource(colorResources.yellowLight.surfaceVariant),
    onSurfaceVariant = colorResource(colorResources.yellowLight.onSurfaceVariant),
    surfaceTint = colorResource(colorResources.yellowLight.surfaceTint),
    inverseSurface = colorResource(colorResources.yellowLight.inverseSurface),
    inverseOnSurface = colorResource(colorResources.yellowLight.inverseOnSurface),
    error = colorResource(colorResources.yellowLight.error),
    onError = colorResource(colorResources.yellowLight.onError),
    errorContainer = colorResource(colorResources.yellowLight.errorContainer),
    onErrorContainer = colorResource(colorResources.yellowLight.onErrorContainer),
    outline = colorResource(colorResources.yellowLight.outline),
    outlineVariant = colorResource(colorResources.yellowLight.outlineVariant),
    scrim = Color.Black
)
@Composable
fun yellowDarkPalette(): ColorScheme = ColorScheme(
    primary = colorResource(colorResources.yellowDark.primary),
    onPrimary = colorResource(colorResources.yellowDark.onPrimary),
    primaryContainer = colorResource(colorResources.yellowDark.primaryContainer),
    onPrimaryContainer = colorResource(colorResources.yellowDark.onPrimaryContainer),
    inversePrimary = colorResource(colorResources.yellowDark.inversePrimary),
    secondary = colorResource(colorResources.yellowDark.secondary),
    onSecondary = colorResource(colorResources.yellowDark.onSecondary),
    secondaryContainer = colorResource(colorResources.yellowDark.secondaryContainer),
    onSecondaryContainer = colorResource(colorResources.yellowDark.onSecondaryContainer),
    tertiary = colorResource(colorResources.yellowDark.tertiary),
    onTertiary = colorResource(colorResources.yellowDark.onTertiary),
    tertiaryContainer = colorResource(colorResources.yellowDark.tertiaryContainer),
    onTertiaryContainer = colorResource(colorResources.yellowDark.onTertiaryContainer),
    background = colorResource(colorResources.yellowDark.background),
    onBackground = colorResource(colorResources.yellowDark.onBackground),
    surface = colorResource(colorResources.yellowDark.surface),
    onSurface = colorResource(colorResources.yellowDark.onSurface),
    surfaceVariant = colorResource(colorResources.yellowDark.surfaceVariant),
    onSurfaceVariant = colorResource(colorResources.yellowDark.onSurfaceVariant),
    surfaceTint = colorResource(colorResources.yellowDark.surfaceTint),
    inverseSurface = colorResource(colorResources.yellowDark.inverseSurface),
    inverseOnSurface = colorResource(colorResources.yellowDark.inverseOnSurface),
    error = colorResource(colorResources.yellowDark.error),
    onError = colorResource(colorResources.yellowDark.onError),
    errorContainer = colorResource(colorResources.yellowDark.errorContainer),
    onErrorContainer = colorResource(colorResources.yellowDark.onErrorContainer),
    outline = colorResource(colorResources.yellowDark.outline),
    outlineVariant = colorResource(colorResources.yellowDark.outlineVariant),
    scrim = Color.Black
)

