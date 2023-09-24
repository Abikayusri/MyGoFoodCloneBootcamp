package abika.sinau.mygofoodclone.features.registration.register.presentation

import abika.sinau.mygofoodclone.http.client.HttpClient
import abika.sinau.mygofoodclone.http.client.HttpClientResult
import abika.sinau.mygofoodclone.domain.request.RegisterRequest
import abika.sinau.mygofoodclone.domain.response.RegisterResponse
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

class RegisterViewModel(
    private val httpClient: HttpClient
) : ViewModel() {

    private val _resultRegister by lazy { MutableSharedFlow<RegisterResponse>() }
    val resultRegister: SharedFlow<RegisterResponse> = _resultRegister

    fun postRegisterUser(
        name: String,
        email: String,
        password: String,
        phoneNumber: String,
        address: String,
        houseNumber: String,
        city: String,
    ) {
        viewModelScope.launch {
            val request = RegisterRequest(
                name, email, password, phoneNumber, address, city, houseNumber, phoneNumber
            )

            httpClient.submitRegister(request).collect { result ->
                when (result) {
                    is HttpClientResult.Success -> {
                        _resultRegister.emit(result.data)
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
                RegisterViewModel(
                    HttpClientFactory.createHttpClientFactory()
                )
            }
        }
    }
}