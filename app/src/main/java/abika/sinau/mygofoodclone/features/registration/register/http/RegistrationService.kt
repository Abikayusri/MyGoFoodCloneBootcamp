package abika.sinau.mygofoodclone.features.registration.register.http

import abika.sinau.mygofoodclone.features.login.domain.request.LoginRequest
import abika.sinau.mygofoodclone.features.login.domain.response.LoginResponse
import abika.sinau.mygofoodclone.util.wrapper.ResponseWrapper
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegistrationService {
    @POST("api/login")
    suspend fun postLogin(
        @Body request: LoginRequest
    ): Response<ResponseWrapper<LoginResponse>>
}