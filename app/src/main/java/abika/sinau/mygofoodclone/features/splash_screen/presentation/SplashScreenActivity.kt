package abika.sinau.mygofoodclone.features.splash_screen.presentation

import abika.sinau.mygofoodclone.MainActivity
import abika.sinau.mygofoodclone.R
import abika.sinau.mygofoodclone.features.login.presentation.LoginActivity
import abika.sinau.mygofoodclone.shared.PrefSession
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            val hasLoginSession = PrefSession(this).hasLogin

            if (hasLoginSession) {
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }, 1500)
    }
}