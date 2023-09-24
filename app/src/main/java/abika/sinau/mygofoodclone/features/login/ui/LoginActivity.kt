package abika.sinau.mygofoodclone.features.login.ui

import abika.sinau.mygofoodclone.MainActivity
import abika.sinau.mygofoodclone.databinding.ActivityLoginBinding
import abika.sinau.mygofoodclone.features.login.presentation.LoginViewModel
import abika.sinau.mygofoodclone.shared.PrefSession
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, LoginViewModel.FACTORY)[LoginViewModel::class.java]

        setupViews()
        setupObservers()
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            viewModel.resultLogin.collectLatest {
                Toast.makeText(this@LoginActivity, "Data: $it", Toast.LENGTH_SHORT).show()

                val prefSession = PrefSession(this@LoginActivity)
                prefSession.hasLogin = true

                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            }
        }
    }

    private fun setupViews() {
        with(binding) {
            btnLogin.setOnClickListener {
                val email = etEmail.text.toString()
                val password = etPassword.text.toString()

                viewModel.postLogin(email, password)
            }
        }
    }
}