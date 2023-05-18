package settings

import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import com.russhwolf.settings.set

class SettingsAuthDataSource(
    private val settings: Settings
) {
    fun saveToken(token: String) {
        settings[tokenKey] = token
    }

    fun fetchToken(): String {
        return settings[tokenKey, ""]
    }

    fun saveDiary(diary: String) {
        settings[diaryKey] = diary
    }

    fun fetchDiary(): String {
        return settings[diaryKey, ""]
    }

    fun saveDevKey(devKeyString: String) {
        settings[devKey] = devKeyString
    }

    fun fetchDevKey(): String {
        return settings[devKey, ""]
    }

    fun saveVendor(vendor: String) {
        settings[vendorKey] = vendor
    }

    fun fetchVendor(): String {
        return settings[vendorKey, ""]
    }


    companion object {
        const val diaryKey = "diaryKey"
        const val tokenKey = "tokenKey"
        const val devKey = "devKey"
        const val vendorKey = "vendorKey"
    }
}