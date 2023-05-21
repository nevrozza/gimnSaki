package theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.gimnsaki.app.MR
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

@Composable
fun defaultLightPalette(): ColorScheme = ColorScheme(
    primary = colorResource(MR.colors.defaultLightPrimary),
    onPrimary = colorResource(MR.colors.defaultLightOnPrimary),
    primaryContainer = colorResource(MR.colors.defaultLightPrimaryContainer),
    onPrimaryContainer = colorResource(MR.colors.defaultLightOnPrimaryContainer),
    inversePrimary = colorResource(MR.colors.defaultLightInversePrimary),
    secondary = colorResource(MR.colors.defaultLightSecondary),
    onSecondary = colorResource(MR.colors.defaultLightOnSecondary),
    secondaryContainer = colorResource(MR.colors.defaultLightSecondaryContainer),
    onSecondaryContainer = colorResource(MR.colors.defaultLightOnSecondaryContainer),
    tertiary = colorResource(MR.colors.defaultLightTertiary),
    onTertiary = colorResource(MR.colors.defaultLightOnTertiary),
    tertiaryContainer = colorResource(MR.colors.defaultLightTertiaryContainer),
    onTertiaryContainer = colorResource(MR.colors.defaultLightOnTertiaryContainer),
    background = colorResource(MR.colors.defaultLightBackground),
    onBackground = colorResource(MR.colors.defaultLightOnBackground),
    surface = colorResource(MR.colors.defaultLightSurface),
    onSurface = colorResource(MR.colors.defaultLightOnSurface),
    surfaceVariant = colorResource(MR.colors.defaultLightSurfaceVariant),
    onSurfaceVariant = colorResource(MR.colors.defaultLightOnSurfaceVariant),
    surfaceTint = colorResource(MR.colors.defaultLightSurfaceTint),
    inverseSurface = colorResource(MR.colors.defaultLightInverseSurface),
    inverseOnSurface = colorResource(MR.colors.defaultLightInverseOnSurface),
    error = colorResource(MR.colors.defaultLightError),
    onError = colorResource(MR.colors.defaultLightOnError),
    errorContainer = colorResource(MR.colors.defaultLightErrorContainer),
    onErrorContainer = colorResource(MR.colors.defaultLightOnErrorContainer),
    outline = colorResource(MR.colors.defaultLightOutline),
    outlineVariant = colorResource(MR.colors.defaultLightOutlineVariant),
    scrim = Color.Black
)
@Composable
fun defaultDarkPalette(): ColorScheme = ColorScheme(
    primary = colorResource(MR.colors.defaultDarkPrimary),
    onPrimary = colorResource(MR.colors.defaultDarkOnPrimary),
    primaryContainer = colorResource(MR.colors.defaultDarkPrimaryContainer),
    onPrimaryContainer = colorResource(MR.colors.defaultDarkOnPrimaryContainer),
    inversePrimary = colorResource(MR.colors.defaultDarkInversePrimary),
    secondary = colorResource(MR.colors.defaultDarkSecondary),
    onSecondary = colorResource(MR.colors.defaultDarkOnSecondary),
    secondaryContainer = colorResource(MR.colors.defaultDarkSecondaryContainer),
    onSecondaryContainer = colorResource(MR.colors.defaultDarkOnSecondaryContainer),
    tertiary = colorResource(MR.colors.defaultDarkTertiary),
    onTertiary = colorResource(MR.colors.defaultDarkOnTertiary),
    tertiaryContainer = colorResource(MR.colors.defaultDarkTertiaryContainer),
    onTertiaryContainer = colorResource(MR.colors.defaultDarkOnTertiaryContainer),
    background = colorResource(MR.colors.defaultDarkBackground),
    onBackground = colorResource(MR.colors.defaultDarkOnBackground),
    surface = colorResource(MR.colors.defaultDarkSurface),
    onSurface = colorResource(MR.colors.defaultDarkOnSurface),
    surfaceVariant = colorResource(MR.colors.defaultDarkSurfaceVariant),
    onSurfaceVariant = colorResource(MR.colors.defaultDarkOnSurfaceVariant),
    surfaceTint = colorResource(MR.colors.defaultDarkSurfaceTint),
    inverseSurface = colorResource(MR.colors.defaultDarkInverseSurface),
    inverseOnSurface = colorResource(MR.colors.defaultDarkInverseOnSurface),
    error = colorResource(MR.colors.defaultDarkError),
    onError = colorResource(MR.colors.defaultDarkOnError),
    errorContainer = colorResource(MR.colors.defaultDarkErrorContainer),
    onErrorContainer = colorResource(MR.colors.defaultDarkOnErrorContainer),
    outline = colorResource(MR.colors.defaultDarkOutline),
    outlineVariant = colorResource(MR.colors.defaultDarkOutlineVariant),
    scrim = Color.Black
)

@Composable
fun greenLightPalette(): ColorScheme = ColorScheme(
    primary = colorResource(MR.colors.greenLightPrimary),
    onPrimary = colorResource(MR.colors.greenLightOnPrimary),
    primaryContainer = colorResource(MR.colors.greenLightPrimaryContainer),
    onPrimaryContainer = colorResource(MR.colors.greenLightOnPrimaryContainer),
    inversePrimary = colorResource(MR.colors.greenLightInversePrimary),
    secondary = colorResource(MR.colors.greenLightSecondary),
    onSecondary = colorResource(MR.colors.greenLightOnSecondary),
    secondaryContainer = colorResource(MR.colors.greenLightSecondaryContainer),
    onSecondaryContainer = colorResource(MR.colors.greenLightOnSecondaryContainer),
    tertiary = colorResource(MR.colors.greenLightTertiary),
    onTertiary = colorResource(MR.colors.greenLightOnTertiary),
    tertiaryContainer = colorResource(MR.colors.greenLightTertiaryContainer),
    onTertiaryContainer = colorResource(MR.colors.greenLightOnTertiaryContainer),
    background = colorResource(MR.colors.greenLightBackground),
    onBackground = colorResource(MR.colors.greenLightOnBackground),
    surface = colorResource(MR.colors.greenLightSurface),
    onSurface = colorResource(MR.colors.greenLightOnSurface),
    surfaceVariant = colorResource(MR.colors.greenLightSurfaceVariant),
    onSurfaceVariant = colorResource(MR.colors.greenLightOnSurfaceVariant),
    surfaceTint = colorResource(MR.colors.greenLightSurfaceTint),
    inverseSurface = colorResource(MR.colors.greenLightInverseSurface),
    inverseOnSurface = colorResource(MR.colors.greenLightInverseOnSurface),
    error = colorResource(MR.colors.greenLightError),
    onError = colorResource(MR.colors.greenLightOnError),
    errorContainer = colorResource(MR.colors.greenLightErrorContainer),
    onErrorContainer = colorResource(MR.colors.greenLightOnErrorContainer),
    outline = colorResource(MR.colors.greenLightOutline),
    outlineVariant = colorResource(MR.colors.greenLightOutlineVariant),
    scrim = Color.Black
)
@Composable
fun greenDarkPalette(): ColorScheme = ColorScheme(
    primary = colorResource(MR.colors.greenDarkPrimary),
    onPrimary = colorResource(MR.colors.greenDarkOnPrimary),
    primaryContainer = colorResource(MR.colors.greenDarkPrimaryContainer),
    onPrimaryContainer = colorResource(MR.colors.greenDarkOnPrimaryContainer),
    inversePrimary = colorResource(MR.colors.greenDarkInversePrimary),
    secondary = colorResource(MR.colors.greenDarkSecondary),
    onSecondary = colorResource(MR.colors.greenDarkOnSecondary),
    secondaryContainer = colorResource(MR.colors.greenDarkSecondaryContainer),
    onSecondaryContainer = colorResource(MR.colors.greenDarkOnSecondaryContainer),
    tertiary = colorResource(MR.colors.greenDarkTertiary),
    onTertiary = colorResource(MR.colors.greenDarkOnTertiary),
    tertiaryContainer = colorResource(MR.colors.greenDarkTertiaryContainer),
    onTertiaryContainer = colorResource(MR.colors.greenDarkOnTertiaryContainer),
    background = colorResource(MR.colors.greenDarkBackground),
    onBackground = colorResource(MR.colors.greenDarkOnBackground),
    surface = colorResource(MR.colors.greenDarkSurface),
    onSurface = colorResource(MR.colors.greenDarkOnSurface),
    surfaceVariant = colorResource(MR.colors.greenDarkSurfaceVariant),
    onSurfaceVariant = colorResource(MR.colors.greenDarkOnSurfaceVariant),
    surfaceTint = colorResource(MR.colors.greenDarkSurfaceTint),
    inverseSurface = colorResource(MR.colors.greenDarkInverseSurface),
    inverseOnSurface = colorResource(MR.colors.greenDarkInverseOnSurface),
    error = colorResource(MR.colors.greenDarkError),
    onError = colorResource(MR.colors.greenDarkOnError),
    errorContainer = colorResource(MR.colors.greenDarkErrorContainer),
    onErrorContainer = colorResource(MR.colors.greenDarkOnErrorContainer),
    outline = colorResource(MR.colors.greenDarkOutline),
    outlineVariant = colorResource(MR.colors.greenDarkOutlineVariant),
    scrim = Color.Black
)

@Composable
fun redLightPalette(): ColorScheme = ColorScheme(
    primary = colorResource(MR.colors.redLightPrimary),
    onPrimary = colorResource(MR.colors.redLightOnPrimary),
    primaryContainer = colorResource(MR.colors.redLightPrimaryContainer),
    onPrimaryContainer = colorResource(MR.colors.redLightOnPrimaryContainer),
    inversePrimary = colorResource(MR.colors.redLightInversePrimary),
    secondary = colorResource(MR.colors.redLightSecondary),
    onSecondary = colorResource(MR.colors.redLightOnSecondary),
    secondaryContainer = colorResource(MR.colors.redLightSecondaryContainer),
    onSecondaryContainer = colorResource(MR.colors.redLightOnSecondaryContainer),
    tertiary = colorResource(MR.colors.redLightTertiary),
    onTertiary = colorResource(MR.colors.redLightOnTertiary),
    tertiaryContainer = colorResource(MR.colors.redLightTertiaryContainer),
    onTertiaryContainer = colorResource(MR.colors.redLightOnTertiaryContainer),
    background = colorResource(MR.colors.redLightBackground),
    onBackground = colorResource(MR.colors.redLightOnBackground),
    surface = colorResource(MR.colors.redLightSurface),
    onSurface = colorResource(MR.colors.redLightOnSurface),
    surfaceVariant = colorResource(MR.colors.redLightSurfaceVariant),
    onSurfaceVariant = colorResource(MR.colors.redLightOnSurfaceVariant),
    surfaceTint = colorResource(MR.colors.redLightSurfaceTint),
    inverseSurface = colorResource(MR.colors.redLightInverseSurface),
    inverseOnSurface = colorResource(MR.colors.redLightInverseOnSurface),
    error = colorResource(MR.colors.redLightError),
    onError = colorResource(MR.colors.redLightOnError),
    errorContainer = colorResource(MR.colors.redLightErrorContainer),
    onErrorContainer = colorResource(MR.colors.redLightOnErrorContainer),
    outline = colorResource(MR.colors.redLightOutline),
    outlineVariant = colorResource(MR.colors.redLightOutlineVariant),
    scrim = Color.Black
)
@Composable
fun redDarkPalette(): ColorScheme = ColorScheme(
    primary = colorResource(MR.colors.redDarkPrimary),
    onPrimary = colorResource(MR.colors.redDarkOnPrimary),
    primaryContainer = colorResource(MR.colors.redDarkPrimaryContainer),
    onPrimaryContainer = colorResource(MR.colors.redDarkOnPrimaryContainer),
    inversePrimary = colorResource(MR.colors.redDarkInversePrimary),
    secondary = colorResource(MR.colors.redDarkSecondary),
    onSecondary = colorResource(MR.colors.redDarkOnSecondary),
    secondaryContainer = colorResource(MR.colors.redDarkSecondaryContainer),
    onSecondaryContainer = colorResource(MR.colors.redDarkOnSecondaryContainer),
    tertiary = colorResource(MR.colors.redDarkTertiary),
    onTertiary = colorResource(MR.colors.redDarkOnTertiary),
    tertiaryContainer = colorResource(MR.colors.redDarkTertiaryContainer),
    onTertiaryContainer = colorResource(MR.colors.redDarkOnTertiaryContainer),
    background = colorResource(MR.colors.redDarkBackground),
    onBackground = colorResource(MR.colors.redDarkOnBackground),
    surface = colorResource(MR.colors.redDarkSurface),
    onSurface = colorResource(MR.colors.redDarkOnSurface),
    surfaceVariant = colorResource(MR.colors.redDarkSurfaceVariant),
    onSurfaceVariant = colorResource(MR.colors.redDarkOnSurfaceVariant),
    surfaceTint = colorResource(MR.colors.redDarkSurfaceTint),
    inverseSurface = colorResource(MR.colors.redDarkInverseSurface),
    inverseOnSurface = colorResource(MR.colors.redDarkInverseOnSurface),
    error = colorResource(MR.colors.redDarkError),
    onError = colorResource(MR.colors.redDarkOnError),
    errorContainer = colorResource(MR.colors.redDarkErrorContainer),
    onErrorContainer = colorResource(MR.colors.redDarkOnErrorContainer),
    outline = colorResource(MR.colors.redDarkOutline),
    outlineVariant = colorResource(MR.colors.redDarkOutlineVariant),
    scrim = Color.Black
)

@Composable
fun yellowLightPalette(): ColorScheme = ColorScheme(
    primary = colorResource(MR.colors.yellowLightPrimary),
    onPrimary = colorResource(MR.colors.yellowLightOnPrimary),
    primaryContainer = colorResource(MR.colors.yellowLightPrimaryContainer),
    onPrimaryContainer = colorResource(MR.colors.yellowLightOnPrimaryContainer),
    inversePrimary = colorResource(MR.colors.yellowLightInversePrimary),
    secondary = colorResource(MR.colors.yellowLightSecondary),
    onSecondary = colorResource(MR.colors.yellowLightOnSecondary),
    secondaryContainer = colorResource(MR.colors.yellowLightSecondaryContainer),
    onSecondaryContainer = colorResource(MR.colors.yellowLightOnSecondaryContainer),
    tertiary = colorResource(MR.colors.yellowLightTertiary),
    onTertiary = colorResource(MR.colors.yellowLightOnTertiary),
    tertiaryContainer = colorResource(MR.colors.yellowLightTertiaryContainer),
    onTertiaryContainer = colorResource(MR.colors.yellowLightOnTertiaryContainer),
    background = colorResource(MR.colors.yellowLightBackground),
    onBackground = colorResource(MR.colors.yellowLightOnBackground),
    surface = colorResource(MR.colors.yellowLightSurface),
    onSurface = colorResource(MR.colors.yellowLightOnSurface),
    surfaceVariant = colorResource(MR.colors.yellowLightSurfaceVariant),
    onSurfaceVariant = colorResource(MR.colors.yellowLightOnSurfaceVariant),
    surfaceTint = colorResource(MR.colors.yellowLightSurfaceTint),
    inverseSurface = colorResource(MR.colors.yellowLightInverseSurface),
    inverseOnSurface = colorResource(MR.colors.yellowLightInverseOnSurface),
    error = colorResource(MR.colors.yellowLightError),
    onError = colorResource(MR.colors.yellowLightOnError),
    errorContainer = colorResource(MR.colors.yellowLightErrorContainer),
    onErrorContainer = colorResource(MR.colors.yellowLightOnErrorContainer),
    outline = colorResource(MR.colors.yellowLightOutline),
    outlineVariant = colorResource(MR.colors.yellowLightOutlineVariant),
    scrim = Color.Black
)
@Composable
fun yellowDarkPalette(): ColorScheme = ColorScheme(
    primary = colorResource(MR.colors.yellowDarkPrimary),
    onPrimary = colorResource(MR.colors.yellowDarkOnPrimary),
    primaryContainer = colorResource(MR.colors.yellowDarkPrimaryContainer),
    onPrimaryContainer = colorResource(MR.colors.yellowDarkOnPrimaryContainer),
    inversePrimary = colorResource(MR.colors.yellowDarkInversePrimary),
    secondary = colorResource(MR.colors.yellowDarkSecondary),
    onSecondary = colorResource(MR.colors.yellowDarkOnSecondary),
    secondaryContainer = colorResource(MR.colors.yellowDarkSecondaryContainer),
    onSecondaryContainer = colorResource(MR.colors.yellowDarkOnSecondaryContainer),
    tertiary = colorResource(MR.colors.yellowDarkTertiary),
    onTertiary = colorResource(MR.colors.yellowDarkOnTertiary),
    tertiaryContainer = colorResource(MR.colors.yellowDarkTertiaryContainer),
    onTertiaryContainer = colorResource(MR.colors.yellowDarkOnTertiaryContainer),
    background = colorResource(MR.colors.yellowDarkBackground),
    onBackground = colorResource(MR.colors.yellowDarkOnBackground),
    surface = colorResource(MR.colors.yellowDarkSurface),
    onSurface = colorResource(MR.colors.yellowDarkOnSurface),
    surfaceVariant = colorResource(MR.colors.yellowDarkSurfaceVariant),
    onSurfaceVariant = colorResource(MR.colors.yellowDarkOnSurfaceVariant),
    surfaceTint = colorResource(MR.colors.yellowDarkSurfaceTint),
    inverseSurface = colorResource(MR.colors.yellowDarkInverseSurface),
    inverseOnSurface = colorResource(MR.colors.yellowDarkInverseOnSurface),
    error = colorResource(MR.colors.yellowDarkError),
    onError = colorResource(MR.colors.yellowDarkOnError),
    errorContainer = colorResource(MR.colors.yellowDarkErrorContainer),
    onErrorContainer = colorResource(MR.colors.yellowDarkOnErrorContainer),
    outline = colorResource(MR.colors.yellowDarkOutline),
    outlineVariant = colorResource(MR.colors.yellowDarkOutlineVariant),
    scrim = Color.Black
)

