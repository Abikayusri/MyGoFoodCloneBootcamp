package abika.sinau.mygofoodclone.factory

import abika.sinau.mygofoodclone.http.GoFoodService
import abika.sinau.mygofoodclone.framework.HttpFactory

class ServiceFactory {
    companion object {
        fun createService(): GoFoodService {
            return HttpFactory.createRetrofit(
                HttpFactory.createMoshi()
            ).create(GoFoodService::class.java)
        }
    }
}