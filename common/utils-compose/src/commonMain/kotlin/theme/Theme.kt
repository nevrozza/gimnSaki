package theme

import MRColors
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.gimnsaki.app.MR
import dev.icerock.moko.resources.ColorResource
import dev.icerock.moko.resources.compose.colorResource
import dev.icerock.moko.resources.desc.color.ColorDesc
import dev.icerock.moko.resources.desc.color.Resource

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
fun defaultLightPalette():
        ColorScheme
= ColorScheme(
        primary =               colorResource(MRColors.defaultLightPrimary),
        onPrimary =             colorResource(MRColors.defaultLightOnPrimary),
        primaryContainer =      colorResource(MRColors.defaultLightPrimaryContainer),
        onPrimaryContainer =    colorResource(MRColors.defaultLightOnPrimaryContainer),
        inversePrimary =        colorResource(MRColors.defaultLightInversePrimary),
        secondary =             colorResource(MRColors.defaultLightSecondary),
        onSecondary =           colorResource(MRColors.defaultLightOnSecondary),
        secondaryContainer =    colorResource(MRColors.defaultLightSecondaryContainer),
        onSecondaryContainer =  colorResource(MRColors.defaultLightOnSecondaryContainer),
        tertiary =              colorResource(MRColors.defaultLightTertiary),
        onTertiary =            colorResource(MRColors.defaultLightOnTertiary),
        tertiaryContainer =     colorResource(MRColors.defaultLightTertiaryContainer),
        onTertiaryContainer =   colorResource(MRColors.defaultLightOnTertiaryContainer),
        background =            colorResource(MRColors.defaultLightBackground),
        onBackground =          colorResource(MRColors.defaultLightOnBackground),
        surface =               colorResource(MRColors.defaultLightSurface),
        onSurface =             colorResource(MRColors.defaultLightOnSurface),
        surfaceVariant =        colorResource(MRColors.defaultLightSurfaceVariant),
        onSurfaceVariant =      colorResource(MRColors.defaultLightOnSurfaceVariant),
        surfaceTint =           colorResource(MRColors.defaultLightSurfaceTint),
        inverseSurface =        colorResource(MRColors.defaultLightInverseSurface),
        inverseOnSurface =      colorResource(MRColors.defaultLightInverseOnSurface),
        error =                 colorResource(MRColors.defaultLightError),
        onError =               colorResource(MRColors.defaultLightOnError),
        errorContainer =        colorResource(MRColors.defaultLightErrorContainer),
        onErrorContainer =      colorResource(MRColors.defaultLightOnErrorContainer),
        outline =               colorResource(MRColors.defaultLightOutline),
        outlineVariant =        colorResource(MRColors.defaultLightOutlineVariant),
        scrim = Color.Black
)

@Composable
fun defaultDarkPalette():
        ColorScheme
= ColorScheme(
    primary =                   colorResource(MRColors.defaultDarkPrimary),
    onPrimary =                 colorResource(MRColors.defaultDarkOnPrimary),
    primaryContainer =          colorResource(MRColors.defaultDarkPrimaryContainer),
    onPrimaryContainer =        colorResource(MRColors.defaultDarkOnPrimaryContainer),
    inversePrimary =            colorResource(MRColors.defaultDarkInversePrimary),
    secondary =                 colorResource(MRColors.defaultDarkSecondary),
    onSecondary =               colorResource(MRColors.defaultDarkOnSecondary),
    secondaryContainer =        colorResource(MRColors.defaultDarkSecondaryContainer),
    onSecondaryContainer =      colorResource(MRColors.defaultDarkOnSecondaryContainer),
    tertiary =                  colorResource(MRColors.defaultDarkTertiary),
    onTertiary =                colorResource(MRColors.defaultDarkOnTertiary),
    tertiaryContainer =         colorResource(MRColors.defaultDarkTertiaryContainer),
    onTertiaryContainer =       colorResource(MRColors.defaultDarkOnTertiaryContainer),
    background =                colorResource(MRColors.defaultDarkBackground),
    onBackground =              colorResource(MRColors.defaultDarkOnBackground),
    surface =                   colorResource(MRColors.defaultDarkSurface),
    onSurface =                 colorResource(MRColors.defaultDarkOnSurface),
    surfaceVariant =            colorResource(MRColors.defaultDarkSurfaceVariant),
    onSurfaceVariant =          colorResource(MRColors.defaultDarkOnSurfaceVariant),
    surfaceTint =               colorResource(MRColors.defaultDarkSurfaceTint),
    inverseSurface =            colorResource(MRColors.defaultDarkInverseSurface),
    inverseOnSurface =          colorResource(MRColors.defaultDarkInverseOnSurface),
    error =                     colorResource(MRColors.defaultDarkError),
    onError =                   colorResource(MRColors.defaultDarkOnError),
    errorContainer =            colorResource(MRColors.defaultDarkErrorContainer),
    onErrorContainer =          colorResource(MRColors.defaultDarkOnErrorContainer),
    outline =                   colorResource(MRColors.defaultDarkOutline),
    outlineVariant =            colorResource(MRColors.defaultDarkOutlineVariant),
    scrim = Color.Black
)

@Composable
fun greenLightPalette():
        ColorScheme
= ColorScheme(
    primary =                   colorResource(MRColors.greenLightPrimary),
    onPrimary =                 colorResource(MRColors.greenLightOnPrimary),
    primaryContainer =          colorResource(MRColors.greenLightPrimaryContainer),
    onPrimaryContainer =        colorResource(MRColors.greenLightOnPrimaryContainer),
    inversePrimary =            colorResource(MRColors.greenLightInversePrimary),
    secondary =                 colorResource(MRColors.greenLightSecondary),
    onSecondary =               colorResource(MRColors.greenLightOnSecondary),
    secondaryContainer =        colorResource(MRColors.greenLightSecondaryContainer),
    onSecondaryContainer =      colorResource(MRColors.greenLightOnSecondaryContainer),
    tertiary =                  colorResource(MRColors.greenLightTertiary),
    onTertiary =                colorResource(MRColors.greenLightOnTertiary),
    tertiaryContainer =         colorResource(MRColors.greenLightTertiaryContainer),
    onTertiaryContainer =       colorResource(MRColors.greenLightOnTertiaryContainer),
    background =                colorResource(MRColors.greenLightBackground),
    onBackground =              colorResource(MRColors.greenLightOnBackground),
    surface =                   colorResource(MRColors.greenLightSurface),
    onSurface =                 colorResource(MRColors.greenLightOnSurface),
    surfaceVariant =            colorResource(MRColors.greenLightSurfaceVariant),
    onSurfaceVariant =          colorResource(MRColors.greenLightOnSurfaceVariant),
    surfaceTint =               colorResource(MRColors.greenLightSurfaceTint),
    inverseSurface =            colorResource(MRColors.greenLightInverseSurface),
    inverseOnSurface =          colorResource(MRColors.greenLightInverseOnSurface),
    error =                     colorResource(MRColors.greenLightError),
    onError =                   colorResource(MRColors.greenLightOnError),
    errorContainer =            colorResource(MRColors.greenLightErrorContainer),
    onErrorContainer =          colorResource(MRColors.greenLightOnErrorContainer),
    outline =                   colorResource(MRColors.greenLightOutline),
    outlineVariant =            colorResource(MRColors.greenLightOutlineVariant),
    scrim = Color.Black
)
@Composable
fun greenDarkPalette():
        ColorScheme
= ColorScheme(
    primary =                   colorResource(MRColors.greenDarkPrimary),
    onPrimary =                 colorResource(MRColors.greenDarkOnPrimary),
    primaryContainer =          colorResource(MRColors.greenDarkPrimaryContainer),
    onPrimaryContainer =        colorResource(MRColors.greenDarkOnPrimaryContainer),
    inversePrimary =            colorResource(MRColors.greenDarkInversePrimary),
    secondary =                 colorResource(MRColors.greenDarkSecondary),
    onSecondary =               colorResource(MRColors.greenDarkOnSecondary),
    secondaryContainer =        colorResource(MRColors.greenDarkSecondaryContainer),
    onSecondaryContainer =      colorResource(MRColors.greenDarkOnSecondaryContainer),
    tertiary =                  colorResource(MRColors.greenDarkTertiary),
    onTertiary =                colorResource(MRColors.greenDarkOnTertiary),
    tertiaryContainer =         colorResource(MRColors.greenDarkTertiaryContainer),
    onTertiaryContainer =       colorResource(MRColors.greenDarkOnTertiaryContainer),
    background =                colorResource(MRColors.greenDarkBackground),
    onBackground =              colorResource(MRColors.greenDarkOnBackground),
    surface =                   colorResource(MRColors.greenDarkSurface),
    onSurface =                 colorResource(MRColors.greenDarkOnSurface),
    surfaceVariant =            colorResource(MRColors.greenDarkSurfaceVariant),
    onSurfaceVariant =          colorResource(MRColors.greenDarkOnSurfaceVariant),
    surfaceTint =               colorResource(MRColors.greenDarkSurfaceTint),
    inverseSurface =            colorResource(MRColors.greenDarkInverseSurface),
    inverseOnSurface =          colorResource(MRColors.greenDarkInverseOnSurface),
    error =                     colorResource(MRColors.greenDarkError),
    onError =                   colorResource(MRColors.greenDarkOnError),
    errorContainer =            colorResource(MRColors.greenDarkErrorContainer),
    onErrorContainer =          colorResource(MRColors.greenDarkOnErrorContainer),
    outline =                   colorResource(MRColors.greenDarkOutline),
    outlineVariant =            colorResource(MRColors.greenDarkOutlineVariant),
    scrim = Color.Black
)

@Composable
fun redLightPalette():
        ColorScheme
= ColorScheme(
    primary =                   colorResource(MRColors.redLightPrimary),
    onPrimary =                 colorResource(MRColors.redLightOnPrimary),
    primaryContainer =          colorResource(MRColors.redLightPrimaryContainer),
    onPrimaryContainer =        colorResource(MRColors.redLightOnPrimaryContainer),
    inversePrimary =            colorResource(MRColors.redLightInversePrimary),
    secondary =                 colorResource(MRColors.redLightSecondary),
    onSecondary =               colorResource(MRColors.redLightOnSecondary),
    secondaryContainer =        colorResource(MRColors.redLightSecondaryContainer),
    onSecondaryContainer =      colorResource(MRColors.redLightOnSecondaryContainer),
    tertiary =                  colorResource(MRColors.redLightTertiary),
    onTertiary =                colorResource(MRColors.redLightOnTertiary),
    tertiaryContainer =         colorResource(MRColors.redLightTertiaryContainer),
    onTertiaryContainer =       colorResource(MRColors.redLightOnTertiaryContainer),
    background =                colorResource(MRColors.redLightBackground),
    onBackground =              colorResource(MRColors.redLightOnBackground),
    surface =                   colorResource(MRColors.redLightSurface),
    onSurface =                 colorResource(MRColors.redLightOnSurface),
    surfaceVariant =            colorResource(MRColors.redLightSurfaceVariant),
    onSurfaceVariant =          colorResource(MRColors.redLightOnSurfaceVariant),
    surfaceTint =               colorResource(MRColors.redLightSurfaceTint),
    inverseSurface =            colorResource(MRColors.redLightInverseSurface),
    inverseOnSurface =          colorResource(MRColors.redLightInverseOnSurface),
    error =                     colorResource(MRColors.redLightError),
    onError =                   colorResource(MRColors.redLightOnError),
    errorContainer =            colorResource(MRColors.redLightErrorContainer),
    onErrorContainer =          colorResource(MRColors.redLightOnErrorContainer),
    outline =                   colorResource(MRColors.redLightOutline),
    outlineVariant =            colorResource(MRColors.redLightOutlineVariant),
    scrim = Color.Black
)
@Composable
fun redDarkPalette():
        ColorScheme
= ColorScheme(
    primary =                   colorResource(MRColors.redDarkPrimary),
    onPrimary =                 colorResource(MRColors.redDarkOnPrimary),
    primaryContainer =          colorResource(MRColors.redDarkPrimaryContainer),
    onPrimaryContainer =        colorResource(MRColors.redDarkOnPrimaryContainer),
    inversePrimary =            colorResource(MRColors.redDarkInversePrimary),
    secondary =                 colorResource(MRColors.redDarkSecondary),
    onSecondary =               colorResource(MRColors.redDarkOnSecondary),
    secondaryContainer =        colorResource(MRColors.redDarkSecondaryContainer),
    onSecondaryContainer =      colorResource(MRColors.redDarkOnSecondaryContainer),
    tertiary =                  colorResource(MRColors.redDarkTertiary),
    onTertiary =                colorResource(MRColors.redDarkOnTertiary),
    tertiaryContainer =         colorResource(MRColors.redDarkTertiaryContainer),
    onTertiaryContainer =       colorResource(MRColors.redDarkOnTertiaryContainer),
    background =                colorResource(MRColors.redDarkBackground),
    onBackground =              colorResource(MRColors.redDarkOnBackground),
    surface =                   colorResource(MRColors.redDarkSurface),
    onSurface =                 colorResource(MRColors.redDarkOnSurface),
    surfaceVariant =            colorResource(MRColors.redDarkSurfaceVariant),
    onSurfaceVariant =          colorResource(MRColors.redDarkOnSurfaceVariant),
    surfaceTint =               colorResource(MRColors.redDarkSurfaceTint),
    inverseSurface =            colorResource(MRColors.redDarkInverseSurface),
    inverseOnSurface =          colorResource(MRColors.redDarkInverseOnSurface),
    error =                     colorResource(MRColors.redDarkError),
    onError =                   colorResource(MRColors.redDarkOnError),
    errorContainer =            colorResource(MRColors.redDarkErrorContainer),
    onErrorContainer =          colorResource(MRColors.redDarkOnErrorContainer),
    outline =                   colorResource(MRColors.redDarkOutline),
    outlineVariant =            colorResource(MRColors.redDarkOutlineVariant),
    scrim = Color.Black
)

@Composable
fun yellowLightPalette():
        ColorScheme
= ColorScheme(
    primary =                   colorResource(MRColors.yellowLightPrimary),
    onPrimary =                 colorResource(MRColors.yellowLightOnPrimary),
    primaryContainer =          colorResource(MRColors.yellowLightPrimaryContainer),
    onPrimaryContainer =        colorResource(MRColors.yellowLightOnPrimaryContainer),
    inversePrimary =            colorResource(MRColors.yellowLightInversePrimary),
    secondary =                 colorResource(MRColors.yellowLightSecondary),
    onSecondary =               colorResource(MRColors.yellowLightOnSecondary),
    secondaryContainer =        colorResource(MRColors.yellowLightSecondaryContainer),
    onSecondaryContainer =      colorResource(MRColors.yellowLightOnSecondaryContainer),
    tertiary =                  colorResource(MRColors.yellowLightTertiary),
    onTertiary =                colorResource(MRColors.yellowLightOnTertiary),
    tertiaryContainer =         colorResource(MRColors.yellowLightTertiaryContainer),
    onTertiaryContainer =       colorResource(MRColors.yellowLightOnTertiaryContainer),
    background =                colorResource(MRColors.yellowLightBackground),
    onBackground =              colorResource(MRColors.yellowLightOnBackground),
    surface =                   colorResource(MRColors.yellowLightSurface),
    onSurface =                 colorResource(MRColors.yellowLightOnSurface),
    surfaceVariant =            colorResource(MRColors.yellowLightSurfaceVariant),
    onSurfaceVariant =          colorResource(MRColors.yellowLightOnSurfaceVariant),
    surfaceTint =               colorResource(MRColors.yellowLightSurfaceTint),
    inverseSurface =            colorResource(MRColors.yellowLightInverseSurface),
    inverseOnSurface =          colorResource(MRColors.yellowLightInverseOnSurface),
    error =                     colorResource(MRColors.yellowLightError),
    onError =                   colorResource(MRColors.yellowLightOnError),
    errorContainer =            colorResource(MRColors.yellowLightErrorContainer),
    onErrorContainer =          colorResource(MRColors.yellowLightOnErrorContainer),
    outline =                   colorResource(MRColors.yellowLightOutline),
    outlineVariant =            colorResource(MRColors.yellowLightOutlineVariant),
    scrim = Color.Black
)
@Composable
fun yellowDarkPalette():
        ColorScheme
= ColorScheme(
    primary =                   colorResource(MRColors.yellowDarkPrimary),
    onPrimary =                 colorResource(MRColors.yellowDarkOnPrimary),
    primaryContainer =          colorResource(MRColors.yellowDarkPrimaryContainer),
    onPrimaryContainer =        colorResource(MRColors.yellowDarkOnPrimaryContainer),
    inversePrimary =            colorResource(MRColors.yellowDarkInversePrimary),
    secondary =                 colorResource(MRColors.yellowDarkSecondary),
    onSecondary =               colorResource(MRColors.yellowDarkOnSecondary),
    secondaryContainer =        colorResource(MRColors.yellowDarkSecondaryContainer),
    onSecondaryContainer =      colorResource(MRColors.yellowDarkOnSecondaryContainer),
    tertiary =                  colorResource(MRColors.yellowDarkTertiary),
    onTertiary =                colorResource(MRColors.yellowDarkOnTertiary),
    tertiaryContainer =         colorResource(MRColors.yellowDarkTertiaryContainer),
    onTertiaryContainer =       colorResource(MRColors.yellowDarkOnTertiaryContainer),
    background =                colorResource(MRColors.yellowDarkBackground),
    onBackground =              colorResource(MRColors.yellowDarkOnBackground),
    surface =                   colorResource(MRColors.yellowDarkSurface),
    onSurface =                 colorResource(MRColors.yellowDarkOnSurface),
    surfaceVariant =            colorResource(MRColors.yellowDarkSurfaceVariant),
    onSurfaceVariant =          colorResource(MRColors.yellowDarkOnSurfaceVariant),
    surfaceTint =               colorResource(MRColors.yellowDarkSurfaceTint),
    inverseSurface =            colorResource(MRColors.yellowDarkInverseSurface),
    inverseOnSurface =          colorResource(MRColors.yellowDarkInverseOnSurface),
    error =                     colorResource(MRColors.yellowDarkError),
    onError =                   colorResource(MRColors.yellowDarkOnError),
    errorContainer =            colorResource(MRColors.yellowDarkErrorContainer),
    onErrorContainer =          colorResource(MRColors.yellowDarkOnErrorContainer),
    outline =                   colorResource(MRColors.yellowDarkOutline),
    outlineVariant =            colorResource(MRColors.yellowDarkOutlineVariant),
    scrim = Color.Black
)

