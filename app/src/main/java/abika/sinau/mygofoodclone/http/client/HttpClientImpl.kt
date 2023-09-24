package abika.sinau.mygofoodclone.http.client

import abika.sinau.mygofoodclone.domain.request.LoginRequest
import abika.sinau.mygofoodclone.domain.request.RegisterRequest
import abika.sinau.mygofoodclone.domain.response.LoginResponse
import abika.sinau.mygofoodclone.domain.response.RegisterResponse
import abika.sinau.mygofoodclone.http.GoFoodService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HttpClientImpl constructor(
    val service: GoFoodService
) : HttpClient {
    override fun submitLogin(request: LoginRequest): Flow<HttpClientResult<LoginResponse>> {
        return flow {
            try {
                val response = service.postLogin(request)
                if (response.isSuccessful) {
                    response.body()?.data?.let {
                        emit(HttpClientResult.Success(it))
                    } ?: run {
                        emit(HttpClientResult.Failure(Exception("Empty Response")))
                    }
                } else {
                    emit(HttpClientResult.Failure(Exception("Error Response")))
                }
            } catch (t: Throwable) {
                emit(HttpClientResult.Failure(t))
            }
        }
    }

    override fun submitRegister(request: RegisterRequest): Flow<HttpClientResult<RegisterResponse>> {
        return flow {
            try {
                val response = service.postRegister(request)
                if (response.isSuccessful) {
                    response.body()?.data?.let {
                        emit(HttpClientResult.Success(it))
                    } ?: run {
                        emit(HttpClientResult.Failure(Exception("Empty Response")))
                    }
                } else {
                    emit(HttpClientResult.Failure(Exception("Error Response")))
                }
            } catch (t: Throwable) {
                emit(HttpClientResult.Failure(t))
            }
        }
    }
}