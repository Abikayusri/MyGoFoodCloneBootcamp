package abika.sinau.mygofoodclone.features.login.presentation

import abika.sinau.mygofoodclone.domain.client.HttpClient
import abika.sinau.mygofoodclone.domain.client.HttpClientResult
import abika.sinau.mygofoodclone.domain.request.LoginRequest
import abika.sinau.mygofoodclone.domain.response.LoginResponse
import abika.sinau.mygofoodclone.factory.HttpClientFactory
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val httpClient: HttpClient
) : ViewModel() {

    private val _resultLogin by lazy { MutableSharedFlow<LoginResponse>() }
    val resultLogin: SharedFlow<LoginResponse> = _resultLogin

    fun postLogin(
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            val request = LoginRequest(email, password)

            httpClient.submitLogin(request).collect { result ->
                when (result) {
                    is HttpClientResult.Success -> {
                        _resultLogin.emit(result.data)
                    }

                    is HttpClientResult.Failure -> {
                        Log.d("TAG", "error: ${result.throwable} ")
                    }
                }
            }
        }
    }

    companion object {
        val FACTORY: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                LoginViewModel(
                    HttpClientFactory.createHttpClientFactory()
                )
            }
        }
    }
}