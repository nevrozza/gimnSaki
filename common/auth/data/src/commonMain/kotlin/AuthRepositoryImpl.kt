import ktor.KtorAuthRemoteDataSource
import ktor.KtorElJurLoginRequest
import models.Token
import settings.SettingsAuthDataSource

class AuthRepositoryImpl(
    private val remoteDataSource: KtorAuthRemoteDataSource,
    private val cacheDataSource: SettingsAuthDataSource
) : AuthRepository {
    override suspend fun login(login: String, password: String, diary: String): Token {
        val token = when (cacheDataSource.fetchDiary()) {
            "eljur" -> {
                remoteDataSource.performElJurLogin(
                    request = KtorElJurLoginRequest(
                        login = login,
                        password = password)
                )
            }
            else -> {Token("")}
        }
        cacheDataSource.saveToken(token.token)
        
        return token
    }

    override fun isUserLoggedIn(): Boolean {
        return cacheDataSource.fetchToken().isNotBlank()
    }

    override fun fetchToken(): String {
        return cacheDataSource.fetchToken()
    }

    override fun saveDiary(diary: String) {
        cacheDataSource.saveDiary(diary)
    }

    override fun fetchDiary(): String {
        return cacheDataSource.fetchDiary()
    }

    override fun saveVendor(vendor: String) {
        cacheDataSource.saveVendor(vendor)
    }

    override fun fetchVendor(): String {
        return cacheDataSource.fetchVendor()
    }

    override fun saveDevKey(devKey: String) {
        cacheDataSource.saveDevKey(devKey)
    }

    override fun fetchDevKey(): String {
        return cacheDataSource.fetchDevKey()
    }
}