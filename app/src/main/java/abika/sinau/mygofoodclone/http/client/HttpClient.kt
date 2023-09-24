package abika.sinau.mygofoodclone.http.client

import abika.sinau.mygofoodclone.domain.request.LoginRequest
import abika.sinau.mygofoodclone.domain.request.RegisterRequest
import abika.sinau.mygofoodclone.domain.response.LoginResponse
import abika.sinau.mygofoodclone.domain.response.RegisterResponse
import kotlinx.coroutines.flow.Flow

interface HttpClient {
    fun submitLogin(request: LoginRequest): Flow<HttpClientResult<LoginResponse>>
    fun submitRegister(request: RegisterRequest): Flow<HttpClientResult<RegisterResponse>>
}