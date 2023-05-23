import com.gimnsaki.app.MR
import dev.icerock.moko.resources.ColorResource
import dev.icerock.moko.resources.StringResource

val MRStrings = DMRStrings()

data class DMRStrings(
    val darkTheme: StringResource                       = MR.strings.darkTheme,
    val lightTheme: StringResource                      = MR.strings.lightTheme,
    val autoTheme: StringResource                       = MR.strings.autoTheme,
    val chooseTheme: StringResource                     = MR.strings.chooseTheme,
    val chooseThemeUnder: StringResource                = MR.strings.chooseThemeUnder
)

val MRColors = DMRColors()

data class DMRColors(
    //Default
    val defaultLightPrimary: ColorResource              = MR.colors.defaultLightPrimary,
    val defaultLightOnPrimary: ColorResource            = MR.colors.defaultLightOnPrimary,
    val defaultLightPrimaryContainer: ColorResource     = MR.colors.defaultLightPrimaryContainer,
    val defaultLightOnPrimaryContainer: ColorResource   = MR.colors.defaultLightOnPrimaryContainer,
    val defaultLightInversePrimary: ColorResource       = MR.colors.defaultLightInversePrimary,
    val defaultLightSecondary: ColorResource            = MR.colors.defaultLightSecondary,
    val defaultLightOnSecondary: ColorResource          = MR.colors.defaultLightOnSecondary,
    val defaultLightSecondaryContainer: ColorResource   = MR.colors.defaultLightSecondaryContainer,
    val defaultLightOnSecondaryContainer: ColorResource = MR.colors.defaultLightOnSecondaryContainer,
    val defaultLightTertiary: ColorResource             = MR.colors.defaultLightTertiary,
    val defaultLightOnTertiary: ColorResource           = MR.colors.defaultLightOnTertiary,
    val defaultLightTertiaryContainer: ColorResource    = MR.colors.defaultLightTertiaryContainer,
    val defaultLightOnTertiaryContainer: ColorResource  = MR.colors.defaultLightOnTertiaryContainer,
    val defaultLightBackground: ColorResource           = MR.colors.defaultLightBackground,
    val defaultLightOnBackground: ColorResource         = MR.colors.defaultLightOnBackground,
    val defaultLightSurface: ColorResource              = MR.colors.defaultLightSurface,
    val defaultLightOnSurface: ColorResource            = MR.colors.defaultLightOnSurface,
    val defaultLightSurfaceVariant: ColorResource       = MR.colors.defaultLightSurfaceVariant,
    val defaultLightOnSurfaceVariant: ColorResource     = MR.colors.defaultLightOnSurfaceVariant,
    val defaultLightSurfaceTint: ColorResource          = MR.colors.defaultLightSurfaceTint,
    val defaultLightInverseSurface: ColorResource       = MR.colors.defaultLightInverseSurface,
    val defaultLightInverseOnSurface: ColorResource     = MR.colors.defaultLightInverseOnSurface,
    val defaultLightError: ColorResource                = MR.colors.defaultLightError,
    val defaultLightOnError: ColorResource              = MR.colors.defaultLightOnError,
    val defaultLightErrorContainer: ColorResource       = MR.colors.defaultLightErrorContainer,
    val defaultLightOnErrorContainer: ColorResource     = MR.colors.defaultLightOnErrorContainer,
    val defaultLightOutline: ColorResource              = MR.colors.defaultLightOutline,
    val defaultLightOutlineVariant: ColorResource       = MR.colors.defaultLightOutlineVariant,

    val defaultDarkPrimary: ColorResource               = MR.colors.defaultDarkPrimary,
    val defaultDarkOnPrimary: ColorResource             = MR.colors.defaultDarkOnPrimary,
    val defaultDarkPrimaryContainer: ColorResource      = MR.colors.defaultDarkPrimaryContainer,
    val defaultDarkOnPrimaryContainer: ColorResource    = MR.colors.defaultDarkOnPrimaryContainer,
    val defaultDarkInversePrimary: ColorResource        = MR.colors.defaultDarkInversePrimary,
    val defaultDarkSecondary: ColorResource             = MR.colors.defaultDarkSecondary,
    val defaultDarkOnSecondary: ColorResource           = MR.colors.defaultDarkOnSecondary,
    val defaultDarkSecondaryContainer: ColorResource    = MR.colors.defaultDarkSecondaryContainer,
    val defaultDarkOnSecondaryContainer: ColorResource  = MR.colors.defaultDarkOnSecondaryContainer,
    val defaultDarkTertiary: ColorResource              = MR.colors.defaultDarkTertiary,
    val defaultDarkOnTertiary: ColorResource            = MR.colors.defaultDarkOnTertiary,
    val defaultDarkTertiaryContainer: ColorResource     = MR.colors.defaultDarkTertiaryContainer,
    val defaultDarkOnTertiaryContainer: ColorResource   = MR.colors.defaultDarkOnTertiaryContainer,
    val defaultDarkBackground: ColorResource            = MR.colors.defaultDarkBackground,
    val defaultDarkOnBackground: ColorResource          = MR.colors.defaultDarkOnBackground,
    val defaultDarkSurface: ColorResource               = MR.colors.defaultDarkSurface,
    val defaultDarkOnSurface: ColorResource             = MR.colors.defaultDarkOnSurface,
    val defaultDarkSurfaceVariant: ColorResource        = MR.colors.defaultDarkSurfaceVariant,
    val defaultDarkOnSurfaceVariant: ColorResource      = MR.colors.defaultDarkOnSurfaceVariant,
    val defaultDarkSurfaceTint: ColorResource           = MR.colors.defaultDarkSurfaceTint,
    val defaultDarkInverseSurface: ColorResource        = MR.colors.defaultDarkInverseSurface,
    val defaultDarkInverseOnSurface: ColorResource      = MR.colors.defaultDarkInverseOnSurface,
    val defaultDarkError: ColorResource                 = MR.colors.defaultDarkError,
    val defaultDarkOnError: ColorResource               = MR.colors.defaultDarkOnError,
    val defaultDarkErrorContainer: ColorResource        = MR.colors.defaultDarkErrorContainer,
    val defaultDarkOnErrorContainer: ColorResource      = MR.colors.defaultDarkOnErrorContainer,
    val defaultDarkOutline: ColorResource               = MR.colors.defaultDarkOutline,
    val defaultDarkOutlineVariant: ColorResource        = MR.colors.defaultDarkOutlineVariant,

    //GREEN
    val greenLightPrimary: ColorResource                = MR.colors.greenLightPrimary,
    val greenLightOnPrimary: ColorResource              = MR.colors.greenLightOnPrimary,
    val greenLightPrimaryContainer: ColorResource       = MR.colors.greenLightPrimaryContainer,
    val greenLightOnPrimaryContainer: ColorResource     = MR.colors.greenLightOnPrimaryContainer,
    val greenLightInversePrimary: ColorResource         = MR.colors.greenLightInversePrimary,
    val greenLightSecondary: ColorResource              = MR.colors.greenLightSecondary,
    val greenLightOnSecondary: ColorResource            = MR.colors.greenLightOnSecondary,
    val greenLightSecondaryContainer: ColorResource     = MR.colors.greenLightSecondaryContainer,
    val greenLightOnSecondaryContainer: ColorResource   = MR.colors.greenLightOnSecondaryContainer,
    val greenLightTertiary: ColorResource               = MR.colors.greenLightTertiary,
    val greenLightOnTertiary: ColorResource             = MR.colors.greenLightOnTertiary,
    val greenLightTertiaryContainer: ColorResource      = MR.colors.greenLightTertiaryContainer,
    val greenLightOnTertiaryContainer: ColorResource    = MR.colors.greenLightOnTertiaryContainer,
    val greenLightBackground: ColorResource             = MR.colors.greenLightBackground,
    val greenLightOnBackground: ColorResource           = MR.colors.greenLightOnBackground,
    val greenLightSurface: ColorResource                = MR.colors.greenLightSurface,
    val greenLightOnSurface: ColorResource              = MR.colors.greenLightOnSurface,
    val greenLightSurfaceVariant: ColorResource         = MR.colors.greenLightSurfaceVariant,
    val greenLightOnSurfaceVariant: ColorResource       = MR.colors.greenLightOnSurfaceVariant,
    val greenLightSurfaceTint: ColorResource            = MR.colors.greenLightSurfaceTint,
    val greenLightInverseSurface: ColorResource         = MR.colors.greenLightInverseSurface,
    val greenLightInverseOnSurface: ColorResource       = MR.colors.greenLightInverseOnSurface,
    val greenLightError: ColorResource                  = MR.colors.greenLightError,
    val greenLightOnError: ColorResource                = MR.colors.greenLightOnError,
    val greenLightErrorContainer: ColorResource         = MR.colors.greenLightErrorContainer,
    val greenLightOnErrorContainer: ColorResource       = MR.colors.greenLightOnErrorContainer,
    val greenLightOutline: ColorResource                = MR.colors.greenLightOutline,
    val greenLightOutlineVariant: ColorResource         = MR.colors.greenLightOutlineVariant,

    val greenDarkPrimary: ColorResource                 = MR.colors.greenDarkPrimary,
    val greenDarkOnPrimary: ColorResource               = MR.colors.greenDarkOnPrimary,
    val greenDarkPrimaryContainer: ColorResource        = MR.colors.greenDarkPrimaryContainer,
    val greenDarkOnPrimaryContainer: ColorResource      = MR.colors.greenDarkOnPrimaryContainer,
    val greenDarkInversePrimary: ColorResource          = MR.colors.greenDarkInversePrimary,
    val greenDarkSecondary: ColorResource               = MR.colors.greenDarkSecondary,
    val greenDarkOnSecondary: ColorResource             = MR.colors.greenDarkOnSecondary,
    val greenDarkSecondaryContainer: ColorResource      = MR.colors.greenDarkSecondaryContainer,
    val greenDarkOnSecondaryContainer: ColorResource    = MR.colors.greenDarkOnSecondaryContainer,
    val greenDarkTertiary: ColorResource                = MR.colors.greenDarkTertiary,
    val greenDarkOnTertiary: ColorResource              = MR.colors.greenDarkOnTertiary,
    val greenDarkTertiaryContainer: ColorResource       = MR.colors.greenDarkTertiaryContainer,
    val greenDarkOnTertiaryContainer: ColorResource     = MR.colors.greenDarkOnTertiaryContainer,
    val greenDarkBackground: ColorResource              = MR.colors.greenDarkBackground,
    val greenDarkOnBackground: ColorResource            = MR.colors.greenDarkOnBackground,
    val greenDarkSurface: ColorResource                 = MR.colors.greenDarkSurface,
    val greenDarkOnSurface: ColorResource               = MR.colors.greenDarkOnSurface,
    val greenDarkSurfaceVariant: ColorResource          = MR.colors.greenDarkSurfaceVariant,
    val greenDarkOnSurfaceVariant: ColorResource        = MR.colors.greenDarkOnSurfaceVariant,
    val greenDarkSurfaceTint: ColorResource             = MR.colors.greenDarkSurfaceTint,
    val greenDarkInverseSurface: ColorResource          = MR.colors.greenDarkInverseSurface,
    val greenDarkInverseOnSurface: ColorResource        = MR.colors.greenDarkInverseOnSurface,
    val greenDarkError: ColorResource                   = MR.colors.greenDarkError,
    val greenDarkOnError: ColorResource                 = MR.colors.greenDarkOnError,
    val greenDarkErrorContainer: ColorResource          = MR.colors.greenDarkErrorContainer,
    val greenDarkOnErrorContainer: ColorResource        = MR.colors.greenDarkOnErrorContainer,
    val greenDarkOutline: ColorResource                 = MR.colors.greenDarkOutline,
    val greenDarkOutlineVariant: ColorResource          = MR.colors.greenDarkOutlineVariant,


    //RED
    val redLightPrimary: ColorResource                 = MR.colors.redLightPrimary,
    val redLightOnPrimary: ColorResource               = MR.colors.redLightOnPrimary,
    val redLightPrimaryContainer: ColorResource        = MR.colors.redLightPrimaryContainer,
    val redLightOnPrimaryContainer: ColorResource      = MR.colors.redLightOnPrimaryContainer,
    val redLightInversePrimary: ColorResource          = MR.colors.redLightInversePrimary,
    val redLightSecondary: ColorResource               = MR.colors.redLightSecondary,
    val redLightOnSecondary: ColorResource             = MR.colors.redLightOnSecondary,
    val redLightSecondaryContainer: ColorResource      = MR.colors.redLightSecondaryContainer,
    val redLightOnSecondaryContainer: ColorResource    = MR.colors.redLightOnSecondaryContainer,
    val redLightTertiary: ColorResource                = MR.colors.redLightTertiary,
    val redLightOnTertiary: ColorResource              = MR.colors.redLightOnTertiary,
    val redLightTertiaryContainer: ColorResource       = MR.colors.redLightTertiaryContainer,
    val redLightOnTertiaryContainer: ColorResource     = MR.colors.redLightOnTertiaryContainer,
    val redLightBackground: ColorResource              = MR.colors.redLightBackground,
    val redLightOnBackground: ColorResource            = MR.colors.redLightOnBackground,
    val redLightSurface: ColorResource                 = MR.colors.redLightSurface,
    val redLightOnSurface: ColorResource               = MR.colors.redLightOnSurface,
    val redLightSurfaceVariant: ColorResource          = MR.colors.redLightSurfaceVariant,
    val redLightOnSurfaceVariant: ColorResource        = MR.colors.redLightOnSurfaceVariant,
    val redLightSurfaceTint: ColorResource             = MR.colors.redLightSurfaceTint,
    val redLightInverseSurface: ColorResource          = MR.colors.redLightInverseSurface,
    val redLightInverseOnSurface: ColorResource        = MR.colors.redLightInverseOnSurface,
    val redLightError: ColorResource                   = MR.colors.redLightError,
    val redLightOnError: ColorResource                 = MR.colors.redLightOnError,
    val redLightErrorContainer: ColorResource          = MR.colors.redLightErrorContainer,
    val redLightOnErrorContainer: ColorResource        = MR.colors.redLightOnErrorContainer,
    val redLightOutline: ColorResource                 = MR.colors.redLightOutline,
    val redLightOutlineVariant: ColorResource          = MR.colors.redLightOutlineVariant,

    val redDarkPrimary: ColorResource                 = MR.colors.redDarkPrimary,
    val redDarkOnPrimary: ColorResource               = MR.colors.redDarkOnPrimary,
    val redDarkPrimaryContainer: ColorResource        = MR.colors.redDarkPrimaryContainer,
    val redDarkOnPrimaryContainer: ColorResource      = MR.colors.redDarkOnPrimaryContainer,
    val redDarkInversePrimary: ColorResource          = MR.colors.redDarkInversePrimary,
    val redDarkSecondary: ColorResource               = MR.colors.redDarkSecondary,
    val redDarkOnSecondary: ColorResource             = MR.colors.redDarkOnSecondary,
    val redDarkSecondaryContainer: ColorResource      = MR.colors.redDarkSecondaryContainer,
    val redDarkOnSecondaryContainer: ColorResource    = MR.colors.redDarkOnSecondaryContainer,
    val redDarkTertiary: ColorResource                = MR.colors.redDarkTertiary,
    val redDarkOnTertiary: ColorResource              = MR.colors.redDarkOnTertiary,
    val redDarkTertiaryContainer: ColorResource       = MR.colors.redDarkTertiaryContainer,
    val redDarkOnTertiaryContainer: ColorResource     = MR.colors.redDarkOnTertiaryContainer,
    val redDarkBackground: ColorResource              = MR.colors.redDarkBackground,
    val redDarkOnBackground: ColorResource            = MR.colors.redDarkOnBackground,
    val redDarkSurface: ColorResource                 = MR.colors.redDarkSurface,
    val redDarkOnSurface: ColorResource               = MR.colors.redDarkOnSurface,
    val redDarkSurfaceVariant: ColorResource          = MR.colors.redDarkSurfaceVariant,
    val redDarkOnSurfaceVariant: ColorResource        = MR.colors.redDarkOnSurfaceVariant,
    val redDarkSurfaceTint: ColorResource             = MR.colors.redDarkSurfaceTint,
    val redDarkInverseSurface: ColorResource          = MR.colors.redDarkInverseSurface,
    val redDarkInverseOnSurface: ColorResource        = MR.colors.redDarkInverseOnSurface,
    val redDarkError: ColorResource                   = MR.colors.redDarkError,
    val redDarkOnError: ColorResource                 = MR.colors.redDarkOnError,
    val redDarkErrorContainer: ColorResource          = MR.colors.redDarkErrorContainer,
    val redDarkOnErrorContainer: ColorResource        = MR.colors.redDarkOnErrorContainer,
    val redDarkOutline: ColorResource                 = MR.colors.redDarkOutline,
    val redDarkOutlineVariant: ColorResource          = MR.colors.redDarkOutlineVariant,

    //YELLOW
    val yellowLightPrimary: ColorResource                 = MR.colors.yellowLightPrimary,
    val yellowLightOnPrimary: ColorResource               = MR.colors.yellowLightOnPrimary,
    val yellowLightPrimaryContainer: ColorResource        = MR.colors.yellowLightPrimaryContainer,
    val yellowLightOnPrimaryContainer: ColorResource      = MR.colors.yellowLightOnPrimaryContainer,
    val yellowLightInversePrimary: ColorResource          = MR.colors.yellowLightInversePrimary,
    val yellowLightSecondary: ColorResource               = MR.colors.yellowLightSecondary,
    val yellowLightOnSecondary: ColorResource             = MR.colors.yellowLightOnSecondary,
    val yellowLightSecondaryContainer: ColorResource      = MR.colors.yellowLightSecondaryContainer,
    val yellowLightOnSecondaryContainer: ColorResource    = MR.colors.yellowLightOnSecondaryContainer,
    val yellowLightTertiary: ColorResource                = MR.colors.yellowLightTertiary,
    val yellowLightOnTertiary: ColorResource              = MR.colors.yellowLightOnTertiary,
    val yellowLightTertiaryContainer: ColorResource       = MR.colors.yellowLightTertiaryContainer,
    val yellowLightOnTertiaryContainer: ColorResource     = MR.colors.yellowLightOnTertiaryContainer,
    val yellowLightBackground: ColorResource              = MR.colors.yellowLightBackground,
    val yellowLightOnBackground: ColorResource            = MR.colors.yellowLightOnBackground,
    val yellowLightSurface: ColorResource                 = MR.colors.yellowLightSurface,
    val yellowLightOnSurface: ColorResource               = MR.colors.yellowLightOnSurface,
    val yellowLightSurfaceVariant: ColorResource          = MR.colors.yellowLightSurfaceVariant,
    val yellowLightOnSurfaceVariant: ColorResource        = MR.colors.yellowLightOnSurfaceVariant,
    val yellowLightSurfaceTint: ColorResource             = MR.colors.yellowLightSurfaceTint,
    val yellowLightInverseSurface: ColorResource          = MR.colors.yellowLightInverseSurface,
    val yellowLightInverseOnSurface: ColorResource        = MR.colors.yellowLightInverseOnSurface,
    val yellowLightError: ColorResource                   = MR.colors.yellowLightError,
    val yellowLightOnError: ColorResource                 = MR.colors.yellowLightOnError,
    val yellowLightErrorContainer: ColorResource          = MR.colors.yellowLightErrorContainer,
    val yellowLightOnErrorContainer: ColorResource        = MR.colors.yellowLightOnErrorContainer,
    val yellowLightOutline: ColorResource                 = MR.colors.yellowLightOutline,
    val yellowLightOutlineVariant: ColorResource          = MR.colors.yellowLightOutlineVariant,

    val yellowDarkPrimary: ColorResource                 = MR.colors.yellowDarkPrimary,
    val yellowDarkOnPrimary: ColorResource               = MR.colors.yellowDarkOnPrimary,
    val yellowDarkPrimaryContainer: ColorResource        = MR.colors.yellowDarkPrimaryContainer,
    val yellowDarkOnPrimaryContainer: ColorResource      = MR.colors.yellowDarkOnPrimaryContainer,
    val yellowDarkInversePrimary: ColorResource          = MR.colors.yellowDarkInversePrimary,
    val yellowDarkSecondary: ColorResource               = MR.colors.yellowDarkSecondary,
    val yellowDarkOnSecondary: ColorResource             = MR.colors.yellowDarkOnSecondary,
    val yellowDarkSecondaryContainer: ColorResource      = MR.colors.yellowDarkSecondaryContainer,
    val yellowDarkOnSecondaryContainer: ColorResource    = MR.colors.yellowDarkOnSecondaryContainer,
    val yellowDarkTertiary: ColorResource                = MR.colors.yellowDarkTertiary,
    val yellowDarkOnTertiary: ColorResource              = MR.colors.yellowDarkOnTertiary,
    val yellowDarkTertiaryContainer: ColorResource       = MR.colors.yellowDarkTertiaryContainer,
    val yellowDarkOnTertiaryContainer: ColorResource     = MR.colors.yellowDarkOnTertiaryContainer,
    val yellowDarkBackground: ColorResource              = MR.colors.yellowDarkBackground,
    val yellowDarkOnBackground: ColorResource            = MR.colors.yellowDarkOnBackground,
    val yellowDarkSurface: ColorResource                 = MR.colors.yellowDarkSurface,
    val yellowDarkOnSurface: ColorResource               = MR.colors.yellowDarkOnSurface,
    val yellowDarkSurfaceVariant: ColorResource          = MR.colors.yellowDarkSurfaceVariant,
    val yellowDarkOnSurfaceVariant: ColorResource        = MR.colors.yellowDarkOnSurfaceVariant,
    val yellowDarkSurfaceTint: ColorResource             = MR.colors.yellowDarkSurfaceTint,
    val yellowDarkInverseSurface: ColorResource          = MR.colors.yellowDarkInverseSurface,
    val yellowDarkInverseOnSurface: ColorResource        = MR.colors.yellowDarkInverseOnSurface,
    val yellowDarkError: ColorResource                   = MR.colors.yellowDarkError,
    val yellowDarkOnError: ColorResource                 = MR.colors.yellowDarkOnError,
    val yellowDarkErrorContainer: ColorResource          = MR.colors.yellowDarkErrorContainer,
    val yellowDarkOnErrorContainer: ColorResource        = MR.colors.yellowDarkOnErrorContainer,
    val yellowDarkOutline: ColorResource                 = MR.colors.yellowDarkOutline,
    val yellowDarkOutlineVariant: ColorResource          = MR.colors.yellowDarkOutlineVariant
)