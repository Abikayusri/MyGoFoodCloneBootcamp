package abika.sinau.mygofoodclone.domain.response


import com.squareup.moshi.Json

data class RegisterResponse(
    @Json(name = "access_token")
    val accessToken: String? = null,
    @Json(name = "token_type")
    val tokenType: String? = null,
    @Json(name = "user")
    val user: User? = null
) {
    data class User(
        @Json(name = "address")
        val address: String? = null,
        @Json(name = "city")
        val city: String? = null,
        @Json(name = "created_at")
        val createdAt: Long? = null,
        @Json(name = "current_team_id")
        val currentTeamId: String? = null,
        @Json(name = "email")
        val email: String? = null,
        @Json(name = "email_verified_at")
        val emailVerifiedAt: String? = null,
        @Json(name = "houseNumber")
        val houseNumber: String? = null,
        @Json(name = "id")
        val id: Int? = null,
        @Json(name = "name")
        val name: String? = null,
        @Json(name = "phoneNumber")
        val phoneNumber: String? = null,
        @Json(name = "profile_photo_path")
        val profilePhotoPath: String? = null,
        @Json(name = "profile_photo_url")
        val profilePhotoUrl: String? = null,
        @Json(name = "roles")
        val roles: String? = null,
        @Json(name = "updated_at")
        val updatedAt: Long? = null
    )
}