package abika.sinau.mygofoodclone.util.wrapper

import com.squareup.moshi.Json


data class ResponseWrapper<T>(
    @Json(name = "data")
    val data: T? = null,
    @Json(name = "meta")
    val meta: Meta? = null
) {
    data class Meta(
        @Json(name = "code")
        val code: Int? = null,
        @Json(name = "message")
        val message: String? = null,
        @Json(name = "status")
        val status: String? = null
    )
}
