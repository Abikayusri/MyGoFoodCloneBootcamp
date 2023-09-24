package abika.sinau.mygofoodclone.features.registration.register.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import abika.sinau.mygofoodclone.databinding.ActivityRegisterBinding
import abika.sinau.mygofoodclone.features.registration.address.ui.AddressActivity
import android.content.Intent
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViews()
    }

    private fun setupViews() {
        with(binding) {
            btnNext.setOnClickListener {
                if (etEmail.text.isNotEmpty() && etName.text.isNotEmpty() && etPassword.text.isNotEmpty()) {
                    val intent = Intent(this@RegisterActivity, AddressActivity::class.java)
                    intent.putExtra("EXTRA_NAME", etName.text.toString())
                    intent.putExtra("EXTRA_EMAIL", etEmail.text.toString())
                    intent.putExtra("EXTRA_PASSWORD", etPassword.text.toString())

                    startActivity(intent)
                } else {
                    Toast.makeText(this@RegisterActivity, "Data masih ada yang kosong", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}