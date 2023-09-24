package abika.sinau.mygofoodclone.http.client

sealed class HttpClientResult<out T> {
    data class Success<out T>(val data: T) : HttpClientResult<T>()

    data class Failure(val throwable: Throwable) : HttpClientResult<Nothing>()
}

class InvalidDataException : Throwable()
class ConnectivityException : Throwable()