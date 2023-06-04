//
//  ColorSchemes.swift
//  iosApp
//
//  Created by nevrozq on 02.06.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

extension SwiftUI.Color {

    init(hex: UInt, alpha: Double = 1) {
        self.init(
            .sRGB,
            red: Double((hex >> 16) & 0xff) / 255,
            green: Double((hex >> 08) & 0xff) / 255,
            blue: Double((hex >> 00) & 0xff) / 255,
            opacity: alpha)
        
    }
}

struct ColorScheme {
    var primary: SwiftUI.Color
    var onPrimary: SwiftUI.Color
    var primaryContainer: SwiftUI.Color
    var onPrimaryContainer: SwiftUI.Color
    var inversePrimary: SwiftUI.Color
    var secondary: SwiftUI.Color
    var onSecondary: SwiftUI.Color
    var secondaryContainer: SwiftUI.Color
    var onSecondaryContainer: SwiftUI.Color
    var tertiary: SwiftUI.Color
    var tertiaryContainer: SwiftUI.Color
    var onTertiaryContainer: SwiftUI.Color
    var background: SwiftUI.Color
    var onBackground: SwiftUI.Color
    var surface: SwiftUI.Color
    var onSurface: SwiftUI.Color
    var surfaceVariant: SwiftUI.Color
    var onSurfaceVariant: SwiftUI.Color
    var surfaceTint: SwiftUI.Color
    var inverseSurface: SwiftUI.Color
    var inverseOnSurface: SwiftUI.Color
    var error: SwiftUI.Color
    var onError: SwiftUI.Color
    var errorContainer: SwiftUI.Color
    var outline: SwiftUI.Color
    var outlineVariant: SwiftUI.Color
    var scrim: SwiftUI.Color = .black
    var colorStr: String
}

var MRColors = DMRColors()

var defaultLightPallete = ColorScheme(
    primary:                SwiftUI.Color(MRColors.defaultLightPrimary.getUIColor()),
    onPrimary:              SwiftUI.Color(MRColors.defaultLightOnPrimary.getUIColor()),
    primaryContainer:       SwiftUI.Color(MRColors.defaultLightPrimaryContainer.getUIColor()),
    onPrimaryContainer:     SwiftUI.Color(MRColors.defaultLightOnPrimaryContainer.getUIColor()),
    inversePrimary:         SwiftUI.Color(MRColors.defaultLightInversePrimary.getUIColor()),
    secondary:              SwiftUI.Color(MRColors.defaultLightSecondary.getUIColor()),
    onSecondary:            SwiftUI.Color(MRColors.defaultLightOnSecondary.getUIColor()),
    secondaryContainer:     SwiftUI.Color(MRColors.defaultLightSecondaryContainer.getUIColor()),
    onSecondaryContainer:   SwiftUI.Color(MRColors.defaultLightOnSecondaryContainer.getUIColor()),
    tertiary:               SwiftUI.Color(MRColors.defaultLightTertiary.getUIColor()),
    tertiaryContainer:      SwiftUI.Color(MRColors.defaultLightTertiaryContainer.getUIColor()),
    onTertiaryContainer:    SwiftUI.Color(MRColors.defaultLightOnTertiaryContainer.getUIColor()),
    background:             SwiftUI.Color(MRColors.defaultLightBackground.getUIColor()),
    onBackground:           SwiftUI.Color(MRColors.defaultLightOnBackground.getUIColor()),
    surface:                SwiftUI.Color(MRColors.defaultLightSurface.getUIColor()),
    onSurface:              SwiftUI.Color(MRColors.defaultLightOnSurface.getUIColor()),
    surfaceVariant:         SwiftUI.Color(MRColors.defaultLightSurfaceVariant.getUIColor()),
    onSurfaceVariant:       SwiftUI.Color(MRColors.defaultLightOnSurfaceVariant.getUIColor()),
    surfaceTint:            SwiftUI.Color(MRColors.defaultLightSurfaceTint.getUIColor()),
    inverseSurface:         SwiftUI.Color(MRColors.defaultLightInverseSurface.getUIColor()),
    inverseOnSurface:       SwiftUI.Color(MRColors.defaultLightInverseOnSurface.getUIColor()),
    error:                  SwiftUI.Color(MRColors.defaultLightError.getUIColor()),
    onError:                SwiftUI.Color(MRColors.defaultLightOnError.getUIColor()),
    errorContainer:         SwiftUI.Color(MRColors.defaultLightErrorContainer.getUIColor()),
    outline:                SwiftUI.Color(MRColors.defaultLightOutline.getUIColor()),
    outlineVariant:         SwiftUI.Color(MRColors.defaultLightOutlineVariant.getUIColor()),
    colorStr:               ThemeColors.default_.name
)

var defaultDarkPallete = ColorScheme(
    primary:                SwiftUI.Color(MRColors.defaultDarkPrimary.getUIColor()),
    onPrimary:              SwiftUI.Color(MRColors.defaultDarkOnPrimary.getUIColor()),
    primaryContainer:       SwiftUI.Color(MRColors.defaultDarkPrimaryContainer.getUIColor()),
    onPrimaryContainer:     SwiftUI.Color(MRColors.defaultDarkOnPrimaryContainer.getUIColor()),
    inversePrimary:         SwiftUI.Color(MRColors.defaultDarkInversePrimary.getUIColor()),
    secondary:              SwiftUI.Color(MRColors.defaultDarkSecondary.getUIColor()),
    onSecondary:            SwiftUI.Color(MRColors.defaultDarkOnSecondary.getUIColor()),
    secondaryContainer:     SwiftUI.Color(MRColors.defaultDarkSecondaryContainer.getUIColor()),
    onSecondaryContainer:   SwiftUI.Color(MRColors.defaultDarkOnSecondaryContainer.getUIColor()),
    tertiary:               SwiftUI.Color(MRColors.defaultDarkTertiary.getUIColor()),
    tertiaryContainer:      SwiftUI.Color(MRColors.defaultDarkTertiaryContainer.getUIColor()),
    onTertiaryContainer:    SwiftUI.Color(MRColors.defaultDarkOnTertiaryContainer.getUIColor()),
    background:             SwiftUI.Color(MRColors.defaultDarkBackground.getUIColor()),
    onBackground:           SwiftUI.Color(MRColors.defaultDarkOnBackground.getUIColor()),
    surface:                SwiftUI.Color(MRColors.defaultDarkSurface.getUIColor()),
    onSurface:              SwiftUI.Color(MRColors.defaultDarkOnSurface.getUIColor()),
    surfaceVariant:         SwiftUI.Color(MRColors.defaultDarkSurfaceVariant.getUIColor()),
    onSurfaceVariant:       SwiftUI.Color(MRColors.defaultDarkOnSurfaceVariant.getUIColor()),
    surfaceTint:            SwiftUI.Color(MRColors.defaultDarkSurfaceTint.getUIColor()),
    inverseSurface:         SwiftUI.Color(MRColors.defaultDarkInverseSurface.getUIColor()),
    inverseOnSurface:       SwiftUI.Color(MRColors.defaultDarkInverseOnSurface.getUIColor()),
    error:                  SwiftUI.Color(MRColors.defaultDarkError.getUIColor()),
    onError:                SwiftUI.Color(MRColors.defaultDarkOnError.getUIColor()),
    errorContainer:         SwiftUI.Color(MRColors.defaultDarkErrorContainer.getUIColor()),
    outline:                SwiftUI.Color(MRColors.defaultDarkOutline.getUIColor()),
    outlineVariant:         SwiftUI.Color(MRColors.defaultDarkOutlineVariant.getUIColor()),
    colorStr:               ThemeColors.default_.name
)

var greenLightPallete = ColorScheme(
    primary:                SwiftUI.Color(MRColors.greenLightPrimary.getUIColor()),
    onPrimary:              SwiftUI.Color(MRColors.greenLightOnPrimary.getUIColor()),
    primaryContainer:       SwiftUI.Color(MRColors.greenLightPrimaryContainer.getUIColor()),
    onPrimaryContainer:     SwiftUI.Color(MRColors.greenLightOnPrimaryContainer.getUIColor()),
    inversePrimary:         SwiftUI.Color(MRColors.greenLightInversePrimary.getUIColor()),
    secondary:              SwiftUI.Color(MRColors.greenLightSecondary.getUIColor()),
    onSecondary:            SwiftUI.Color(MRColors.greenLightOnSecondary.getUIColor()),
    secondaryContainer:     SwiftUI.Color(MRColors.greenLightSecondaryContainer.getUIColor()),
    onSecondaryContainer:   SwiftUI.Color(MRColors.greenLightOnSecondaryContainer.getUIColor()),
    tertiary:               SwiftUI.Color(MRColors.greenLightTertiary.getUIColor()),
    tertiaryContainer:      SwiftUI.Color(MRColors.greenLightTertiaryContainer.getUIColor()),
    onTertiaryContainer:    SwiftUI.Color(MRColors.greenLightOnTertiaryContainer.getUIColor()),
    background:             SwiftUI.Color(MRColors.greenLightBackground.getUIColor()),
    onBackground:           SwiftUI.Color(MRColors.greenLightOnBackground.getUIColor()),
    surface:                SwiftUI.Color(MRColors.greenLightSurface.getUIColor()),
    onSurface:              SwiftUI.Color(MRColors.greenLightOnSurface.getUIColor()),
    surfaceVariant:         SwiftUI.Color(MRColors.greenLightSurfaceVariant.getUIColor()),
    onSurfaceVariant:       SwiftUI.Color(MRColors.greenLightOnSurfaceVariant.getUIColor()),
    surfaceTint:            SwiftUI.Color(MRColors.greenLightSurfaceTint.getUIColor()),
    inverseSurface:         SwiftUI.Color(MRColors.greenLightInverseSurface.getUIColor()),
    inverseOnSurface:       SwiftUI.Color(MRColors.greenLightInverseOnSurface.getUIColor()),
    error:                  SwiftUI.Color(MRColors.greenLightError.getUIColor()),
    onError:                SwiftUI.Color(MRColors.greenLightOnError.getUIColor()),
    errorContainer:         SwiftUI.Color(MRColors.greenLightErrorContainer.getUIColor()),
    outline:                SwiftUI.Color(MRColors.greenLightOutline.getUIColor()),
    outlineVariant:         SwiftUI.Color(MRColors.greenLightOutlineVariant.getUIColor()),
    colorStr:               ThemeColors.green.name
)

var greenDarkPallete = ColorScheme(
    primary:                SwiftUI.Color(MRColors.greenDarkPrimary.getUIColor()),
    onPrimary:              SwiftUI.Color(MRColors.greenDarkOnPrimary.getUIColor()),
    primaryContainer:       SwiftUI.Color(MRColors.greenDarkPrimaryContainer.getUIColor()),
    onPrimaryContainer:     SwiftUI.Color(MRColors.greenDarkOnPrimaryContainer.getUIColor()),
    inversePrimary:         SwiftUI.Color(MRColors.greenDarkInversePrimary.getUIColor()),
    secondary:              SwiftUI.Color(MRColors.greenDarkSecondary.getUIColor()),
    onSecondary:            SwiftUI.Color(MRColors.greenDarkOnSecondary.getUIColor()),
    secondaryContainer:     SwiftUI.Color(MRColors.greenDarkSecondaryContainer.getUIColor()),
    onSecondaryContainer:   SwiftUI.Color(MRColors.greenDarkOnSecondaryContainer.getUIColor()),
    tertiary:               SwiftUI.Color(MRColors.greenDarkTertiary.getUIColor()),
    tertiaryContainer:      SwiftUI.Color(MRColors.greenDarkTertiaryContainer.getUIColor()),
    onTertiaryContainer:    SwiftUI.Color(MRColors.greenDarkOnTertiaryContainer.getUIColor()),
    background:             SwiftUI.Color(MRColors.greenDarkBackground.getUIColor()),
    onBackground:           SwiftUI.Color(MRColors.greenDarkOnBackground.getUIColor()),
    surface:                SwiftUI.Color(MRColors.greenDarkSurface.getUIColor()),
    onSurface:              SwiftUI.Color(MRColors.greenDarkOnSurface.getUIColor()),
    surfaceVariant:         SwiftUI.Color(MRColors.greenDarkSurfaceVariant.getUIColor()),
    onSurfaceVariant:       SwiftUI.Color(MRColors.greenDarkOnSurfaceVariant.getUIColor()),
    surfaceTint:            SwiftUI.Color(MRColors.greenDarkSurfaceTint.getUIColor()),
    inverseSurface:         SwiftUI.Color(MRColors.greenDarkInverseSurface.getUIColor()),
    inverseOnSurface:       SwiftUI.Color(MRColors.greenDarkInverseOnSurface.getUIColor()),
    error:                  SwiftUI.Color(MRColors.greenDarkError.getUIColor()),
    onError:                SwiftUI.Color(MRColors.greenDarkOnError.getUIColor()),
    errorContainer:         SwiftUI.Color(MRColors.greenDarkErrorContainer.getUIColor()),
    outline:                SwiftUI.Color(MRColors.greenDarkOutline.getUIColor()),
    outlineVariant:         SwiftUI.Color(MRColors.greenDarkOutlineVariant.getUIColor()),
    colorStr:               ThemeColors.green.name
)

var redLightPallete = ColorScheme(
    primary:                SwiftUI.Color(MRColors.redLightPrimary.getUIColor()),
    onPrimary:              SwiftUI.Color(MRColors.redLightOnPrimary.getUIColor()),
    primaryContainer:       SwiftUI.Color(MRColors.redLightPrimaryContainer.getUIColor()),
    onPrimaryContainer:     SwiftUI.Color(MRColors.redLightOnPrimaryContainer.getUIColor()),
    inversePrimary:         SwiftUI.Color(MRColors.redLightInversePrimary.getUIColor()),
    secondary:              SwiftUI.Color(MRColors.redLightSecondary.getUIColor()),
    onSecondary:            SwiftUI.Color(MRColors.redLightOnSecondary.getUIColor()),
    secondaryContainer:     SwiftUI.Color(MRColors.redLightSecondaryContainer.getUIColor()),
    onSecondaryContainer:   SwiftUI.Color(MRColors.redLightOnSecondaryContainer.getUIColor()),
    tertiary:               SwiftUI.Color(MRColors.redLightTertiary.getUIColor()),
    tertiaryContainer:      SwiftUI.Color(MRColors.redLightTertiaryContainer.getUIColor()),
    onTertiaryContainer:    SwiftUI.Color(MRColors.redLightOnTertiaryContainer.getUIColor()),
    background:             SwiftUI.Color(MRColors.redLightBackground.getUIColor()),
    onBackground:           SwiftUI.Color(MRColors.redLightOnBackground.getUIColor()),
    surface:                SwiftUI.Color(MRColors.redLightSurface.getUIColor()),
    onSurface:              SwiftUI.Color(MRColors.redLightOnSurface.getUIColor()),
    surfaceVariant:         SwiftUI.Color(MRColors.redLightSurfaceVariant.getUIColor()),
    onSurfaceVariant:       SwiftUI.Color(MRColors.redLightOnSurfaceVariant.getUIColor()),
    surfaceTint:            SwiftUI.Color(MRColors.redLightSurfaceTint.getUIColor()),
    inverseSurface:         SwiftUI.Color(MRColors.redLightInverseSurface.getUIColor()),
    inverseOnSurface:       SwiftUI.Color(MRColors.redLightInverseOnSurface.getUIColor()),
    error:                  SwiftUI.Color(MRColors.redLightError.getUIColor()),
    onError:                SwiftUI.Color(MRColors.redLightOnError.getUIColor()),
    errorContainer:         SwiftUI.Color(MRColors.redLightErrorContainer.getUIColor()),
    outline:                SwiftUI.Color(MRColors.redLightOutline.getUIColor()),
    outlineVariant:         SwiftUI.Color(MRColors.redLightOutlineVariant.getUIColor()),
    colorStr:               ThemeColors.red.name
)

var redDarkPallete = ColorScheme(
    primary:                SwiftUI.Color(MRColors.redDarkPrimary.getUIColor()),
    onPrimary:              SwiftUI.Color(MRColors.redDarkOnPrimary.getUIColor()),
    primaryContainer:       SwiftUI.Color(MRColors.redDarkPrimaryContainer.getUIColor()),
    onPrimaryContainer:     SwiftUI.Color(MRColors.redDarkOnPrimaryContainer.getUIColor()),
    inversePrimary:         SwiftUI.Color(MRColors.redDarkInversePrimary.getUIColor()),
    secondary:              SwiftUI.Color(MRColors.redDarkSecondary.getUIColor()),
    onSecondary:            SwiftUI.Color(MRColors.redDarkOnSecondary.getUIColor()),
    secondaryContainer:     SwiftUI.Color(MRColors.redDarkSecondaryContainer.getUIColor()),
    onSecondaryContainer:   SwiftUI.Color(MRColors.redDarkOnSecondaryContainer.getUIColor()),
    tertiary:               SwiftUI.Color(MRColors.redDarkTertiary.getUIColor()),
    tertiaryContainer:      SwiftUI.Color(MRColors.redDarkTertiaryContainer.getUIColor()),
    onTertiaryContainer:    SwiftUI.Color(MRColors.redDarkOnTertiaryContainer.getUIColor()),
    background:             SwiftUI.Color(MRColors.redDarkBackground.getUIColor()),
    onBackground:           SwiftUI.Color(MRColors.redDarkOnBackground.getUIColor()),
    surface:                SwiftUI.Color(MRColors.redDarkSurface.getUIColor()),
    onSurface:              SwiftUI.Color(MRColors.redDarkOnSurface.getUIColor()),
    surfaceVariant:         SwiftUI.Color(MRColors.redDarkSurfaceVariant.getUIColor()),
    onSurfaceVariant:       SwiftUI.Color(MRColors.redDarkOnSurfaceVariant.getUIColor()),
    surfaceTint:            SwiftUI.Color(MRColors.redDarkSurfaceTint.getUIColor()),
    inverseSurface:         SwiftUI.Color(MRColors.redDarkInverseSurface.getUIColor()),
    inverseOnSurface:       SwiftUI.Color(MRColors.redDarkInverseOnSurface.getUIColor()),
    error:                  SwiftUI.Color(MRColors.redDarkError.getUIColor()),
    onError:                SwiftUI.Color(MRColors.redDarkOnError.getUIColor()),
    errorContainer:         SwiftUI.Color(MRColors.redDarkErrorContainer.getUIColor()),
    outline:                SwiftUI.Color(MRColors.redDarkOutline.getUIColor()),
    outlineVariant:         SwiftUI.Color(MRColors.redDarkOutlineVariant.getUIColor()),
    colorStr:               ThemeColors.red.name
)

var yellowLightPallete = ColorScheme(
    primary:                SwiftUI.Color(MRColors.yellowLightPrimary.getUIColor()),
    onPrimary:              SwiftUI.Color(MRColors.yellowLightOnPrimary.getUIColor()),
    primaryContainer:       SwiftUI.Color(MRColors.yellowLightPrimaryContainer.getUIColor()),
    onPrimaryContainer:     SwiftUI.Color(MRColors.yellowLightOnPrimaryContainer.getUIColor()),
    inversePrimary:         SwiftUI.Color(MRColors.yellowLightInversePrimary.getUIColor()),
    secondary:              SwiftUI.Color(MRColors.yellowLightSecondary.getUIColor()),
    onSecondary:            SwiftUI.Color(MRColors.yellowLightOnSecondary.getUIColor()),
    secondaryContainer:     SwiftUI.Color(MRColors.yellowLightSecondaryContainer.getUIColor()),
    onSecondaryContainer:   SwiftUI.Color(MRColors.yellowLightOnSecondaryContainer.getUIColor()),
    tertiary:               SwiftUI.Color(MRColors.yellowLightTertiary.getUIColor()),
    tertiaryContainer:      SwiftUI.Color(MRColors.yellowLightTertiaryContainer.getUIColor()),
    onTertiaryContainer:    SwiftUI.Color(MRColors.yellowLightOnTertiaryContainer.getUIColor()),
    background:             SwiftUI.Color(MRColors.yellowLightBackground.getUIColor()),
    onBackground:           SwiftUI.Color(MRColors.yellowLightOnBackground.getUIColor()),
    surface:                SwiftUI.Color(MRColors.yellowLightSurface.getUIColor()),
    onSurface:              SwiftUI.Color(MRColors.yellowLightOnSurface.getUIColor()),
    surfaceVariant:         SwiftUI.Color(MRColors.yellowLightSurfaceVariant.getUIColor()),
    onSurfaceVariant:       SwiftUI.Color(MRColors.yellowLightOnSurfaceVariant.getUIColor()),
    surfaceTint:            SwiftUI.Color(MRColors.yellowLightSurfaceTint.getUIColor()),
    inverseSurface:         SwiftUI.Color(MRColors.yellowLightInverseSurface.getUIColor()),
    inverseOnSurface:       SwiftUI.Color(MRColors.yellowLightInverseOnSurface.getUIColor()),
    error:                  SwiftUI.Color(MRColors.yellowLightError.getUIColor()),
    onError:                SwiftUI.Color(MRColors.yellowLightOnError.getUIColor()),
    errorContainer:         SwiftUI.Color(MRColors.yellowLightErrorContainer.getUIColor()),
    outline:                SwiftUI.Color(MRColors.yellowLightOutline.getUIColor()),
    outlineVariant:         SwiftUI.Color(MRColors.yellowLightOutlineVariant.getUIColor()),
    colorStr:               ThemeColors.yellow.name
)

var yellowDarkPallete = ColorScheme(
    primary:                SwiftUI.Color(MRColors.yellowDarkPrimary.getUIColor()),
    onPrimary:              SwiftUI.Color(MRColors.yellowDarkOnPrimary.getUIColor()),
    primaryContainer:       SwiftUI.Color(MRColors.yellowDarkPrimaryContainer.getUIColor()),
    onPrimaryContainer:     SwiftUI.Color(MRColors.yellowDarkOnPrimaryContainer.getUIColor()),
    inversePrimary:         SwiftUI.Color(MRColors.yellowDarkInversePrimary.getUIColor()),
    secondary:              SwiftUI.Color(MRColors.yellowDarkSecondary.getUIColor()),
    onSecondary:            SwiftUI.Color(MRColors.yellowDarkOnSecondary.getUIColor()),
    secondaryContainer:     SwiftUI.Color(MRColors.yellowDarkSecondaryContainer.getUIColor()),
    onSecondaryContainer:   SwiftUI.Color(MRColors.yellowDarkOnSecondaryContainer.getUIColor()),
    tertiary:               SwiftUI.Color(MRColors.yellowDarkTertiary.getUIColor()),
    tertiaryContainer:      SwiftUI.Color(MRColors.yellowDarkTertiaryContainer.getUIColor()),
    onTertiaryContainer:    SwiftUI.Color(MRColors.yellowDarkOnTertiaryContainer.getUIColor()),
    background:             SwiftUI.Color(MRColors.yellowDarkBackground.getUIColor()),
    onBackground:           SwiftUI.Color(MRColors.yellowDarkOnBackground.getUIColor()),
    surface:                SwiftUI.Color(MRColors.yellowDarkSurface.getUIColor()),
    onSurface:              SwiftUI.Color(MRColors.yellowDarkOnSurface.getUIColor()),
    surfaceVariant:         SwiftUI.Color(MRColors.yellowDarkSurfaceVariant.getUIColor()),
    onSurfaceVariant:       SwiftUI.Color(MRColors.yellowDarkOnSurfaceVariant.getUIColor()),
    surfaceTint:            SwiftUI.Color(MRColors.yellowDarkSurfaceTint.getUIColor()),
    inverseSurface:         SwiftUI.Color(MRColors.yellowDarkInverseSurface.getUIColor()),
    inverseOnSurface:       SwiftUI.Color(MRColors.yellowDarkInverseOnSurface.getUIColor()),
    error:                  SwiftUI.Color(MRColors.yellowDarkError.getUIColor()),
    onError:                SwiftUI.Color(MRColors.yellowDarkOnError.getUIColor()),
    errorContainer:         SwiftUI.Color(MRColors.yellowDarkErrorContainer.getUIColor()),
    outline:                SwiftUI.Color(MRColors.yellowDarkOutline.getUIColor()),
    outlineVariant:         SwiftUI.Color(MRColors.yellowDarkOutlineVariant.getUIColor()),
    colorStr:               ThemeColors.yellow.name
)
