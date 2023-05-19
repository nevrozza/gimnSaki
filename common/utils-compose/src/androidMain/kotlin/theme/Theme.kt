package theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.platform.LocalViewConfiguration
import com.gimnsaki.app.MR
import dev.icerock.moko.resources.compose.colorResource

@Composable
actual fun AppTheme(colorScheme: ColorScheme, darkTheme: Boolean, isDynamic: Boolean, content: @Composable () -> Unit) {
    val palette = when {
        isDynamic && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        else -> colorScheme
    }

    MaterialTheme(
        colorScheme = palette,
        content = content,

    )
}

@Composable
actual fun greenLightPalette(): ColorScheme = ColorScheme(
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
    scrim = Color.White
)

@Composable
actual fun greenDarkPalette(): ColorScheme = ColorScheme(
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