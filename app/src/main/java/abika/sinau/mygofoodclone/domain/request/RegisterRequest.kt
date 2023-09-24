package abika.sinau.mygofoodclone.domain.request

import android.os.Parcelable

data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String,
    val passwordConfirmation: String,
    val address: String,
    val city: String,
    val houseNumber: String,
    val phoneNumber: String,
)