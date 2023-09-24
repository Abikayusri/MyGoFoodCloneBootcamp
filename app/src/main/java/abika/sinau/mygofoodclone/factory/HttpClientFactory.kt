package abika.sinau.mygofoodclone.factory

import abika.sinau.mygofoodclone.domain.client.HttpClient
import abika.sinau.mygofoodclone.domain.client.HttpClientImpl

class HttpClientFactory {
    companion object {
        fun createHttpClientFactory(): HttpClient {
            return HttpClientImpl(ServiceFactory.createService())
        }
    }
}