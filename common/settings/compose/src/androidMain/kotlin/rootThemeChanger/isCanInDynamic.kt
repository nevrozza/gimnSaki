package rootThemeChanger

import android.os.Build
import themeCodes.ThemeColors

actual fun isCanInDynamic(): Boolean  = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
