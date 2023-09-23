package abika.sinau.mygofoodclone.features.registration.register.domain.request

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
