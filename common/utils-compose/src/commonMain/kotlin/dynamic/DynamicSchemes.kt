package dynamic

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable

@Composable
expect fun dynamicDarkScheme(): ColorScheme?

@Composable
expect fun dynamicLightScheme(): ColorScheme?
