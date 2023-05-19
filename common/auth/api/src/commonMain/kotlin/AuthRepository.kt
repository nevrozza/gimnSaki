import models.Token

interface AuthRepository {

    suspend fun login(login: String, password: String, diary: String): Token
    fun isUserLoggedIn(): Boolean
    fun fetchToken(): String

    fun saveDiary(diary: String)
    fun fetchDiary(): String

    fun saveVendor(vendor: String)
    fun fetchVendor(): String

    fun saveDevKey(devKey: String)
    fun fetchDevKey(): String

    fun saveLogin(login: String)

    fun fetchLogin(): String

    fun savePassword(password: String)

    fun fetchPassword(): String

    fun saveSheets(sheetsToken: String)

    fun fetchSheets(): String
}