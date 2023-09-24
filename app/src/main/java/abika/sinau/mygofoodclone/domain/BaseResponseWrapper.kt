package abika.sinau.mygofoodclone.domain


import com.squareup.moshi.Json

data class BaseResponseWrapper<T : Any>(
    @Json(name = "data")
    val data: T? = null,
    @Json(name = "meta")
    val meta: MetaResponse? = null
) {
    data class MetaResponse(
        @Json(name = "code")
        val code: Int? = null,
        @Json(name = "message")
        val message: String? = null,
        @Json(name = "status")
        val status: String? = null
    )
}