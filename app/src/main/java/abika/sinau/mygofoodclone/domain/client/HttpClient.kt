package abika.sinau.mygofoodclone.domain.client

import abika.sinau.mygofoodclone.domain.request.LoginRequest
import abika.sinau.mygofoodclone.domain.response.LoginResponse
import kotlinx.coroutines.flow.Flow

interface HttpClient {
    fun submitLogin(request: LoginRequest): Flow<HttpClientResult<LoginResponse>>
}