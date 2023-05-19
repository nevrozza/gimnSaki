package settings

import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import com.russhwolf.settings.set
import models.Token

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
        return settings[devKey, "c4ca4238a0b923820dcc509a6f75849b"]
    }

    fun saveVendor(vendor: String) {
        settings[vendorKey] = vendor
    }

    fun fetchVendor(): String {
        return settings[vendorKey, ""]
    }

    fun saveLogin(login: String) {
        settings[loginKey] = login
    }

    fun fetchLogin(): String {
        return settings[loginKey, ""]
    }

    fun savePassword(password: String) {
        settings[passwordKey] = password
    }

    fun fetchPassword(): String {
        return settings[passwordKey, ""]
    }

    fun saveSheets(sheetsToken: String) {
        settings[sheetsKey] = sheetsToken
    }

    fun fetchSheets(): String {
        return settings[sheetsKey, ""]
    }


    companion object {
        const val sheetsKey = "sheetsKey"
        const val loginKey = "loginKey"
        const val passwordKey = "loginKey"
        const val diaryKey = "diaryKey"
        const val tokenKey = "tokenKey"
        const val devKey = "devKey"
        const val vendorKey = "vendorKey"
    }
}