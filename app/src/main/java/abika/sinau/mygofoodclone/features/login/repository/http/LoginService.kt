package abika.sinau.mygofoodclone.features.login.repository.http

import abika.sinau.mygofoodclone.features.registration.register.domain.request.RegisterRequest
import abika.sinau.mygofoodclone.features.registration.register.domain.response.RegisterResponse
import abika.sinau.mygofoodclone.util.wrapper.ResponseWrapper
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("api/register")
    suspend fun postRegister(
        @Body request: RegisterRequest
    ): Response<ResponseWrapper<RegisterResponse>>
}