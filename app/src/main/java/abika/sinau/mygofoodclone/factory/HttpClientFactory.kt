package abika.sinau.mygofoodclone.factory

import abika.sinau.mygofoodclone.http.client.HttpClient
import abika.sinau.mygofoodclone.http.client.HttpClientImpl

class HttpClientFactory {
    companion object {
        fun createHttpClientFactory(): HttpClient {
            return HttpClientImpl(ServiceFactory.createService())
        }
    }
}