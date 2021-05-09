package com.devdhruv.user.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Window
import android.view.WindowManager
import com.devdhruv.user.R
import com.google.firebase.auth.FirebaseAuth

class UserSplashActivity : AppCompatActivity() {

    val auth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_splash)

        supportActionBar?.hide()
        val w: Window = window
        w.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        Handler(Looper.getMainLooper()).postDelayed(
            {
                if (auth.currentUser != null) {
                    startActivity(Intent(applicationContext, UserMainActivity::class.java))
                } else {
                    startActivity(Intent(applicationContext, UserAuthActivity::class.java))
                }
            },
            2500
        )

    }
}