package abika.sinau.mygofoodclone.http

import abika.sinau.mygofoodclone.domain.BaseResponseWrapper
import abika.sinau.mygofoodclone.domain.request.LoginRequest
import abika.sinau.mygofoodclone.domain.request.RegisterRequest
import abika.sinau.mygofoodclone.domain.response.LoginResponse
import abika.sinau.mygofoodclone.domain.response.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface GoFoodService {
    @POST("login")
    suspend fun postLogin(
        @Body request: LoginRequest
    ): Response<BaseResponseWrapper<LoginResponse>>

    @POST("register")
    suspend fun postRegister(
        @Body request: RegisterRequest
    ): Response<BaseResponseWrapper<RegisterResponse>>
}