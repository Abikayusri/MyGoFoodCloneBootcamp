package abika.sinau.mygofoodclone.domain.service

import abika.sinau.mygofoodclone.domain.BaseResponseWrapper
import abika.sinau.mygofoodclone.domain.request.LoginRequest
import abika.sinau.mygofoodclone.domain.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface GoFoodService {
    @POST("login")
    suspend fun postLogin(
        @Body request: LoginRequest
    ): Response<BaseResponseWrapper<LoginResponse>>
}