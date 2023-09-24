package abika.sinau.mygofoodclone.features.registration.address.ui

import abika.sinau.mygofoodclone.databinding.ActivityAddressBinding
import abika.sinau.mygofoodclone.features.login.presentation.LoginViewModel
import abika.sinau.mygofoodclone.features.registration.register.presentation.RegisterViewModel
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class AddressActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddressBinding
    private lateinit var viewModel: RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, LoginViewModel.FACTORY)[RegisterViewModel::class.java]

        setupViews()
        setupObservers()
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            viewModel.resultRegister.collectLatest {
                Toast.makeText(this@AddressActivity, "Data: $it", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupViews() {
        val email = intent.getStringExtra("EXTRA_EMAIL")
        val name = intent.getStringExtra("EXTRA_NAME")
        val password = intent.getStringExtra("EXTRA_PASSWORD")

        with(binding) {
            btnRegist.setOnClickListener {
                if (etAddress.text.isNotEmpty() && etCity.text.isNotEmpty() && etHouseNumber.text.isNotEmpty() && etPhoneNumber.text.isNotEmpty()) {
                    viewModel.postRegisterUser(
                        name.toString(),
                        email.toString(),
                        password.toString(),
                        etPhoneNumber.text.toString(),
                        etAddress.text.toString(),
                        etHouseNumber.text.toString(),
                        etPhoneNumber.text.toString()
                    )
                } else {
                    Toast.makeText(
                        this@AddressActivity,
                        "Data masih ada yang kosong",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}