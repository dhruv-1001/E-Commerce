package com.devdhruv.ecommerce.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.devdhruv.ecommerce.R
import com.google.firebase.auth.FirebaseAuth

class VendorSplashActivity: AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vendor_splash)

        supportActionBar?.hide()
        val w: Window = window
        w.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        mAuth = FirebaseAuth.getInstance()

        Handler(Looper.getMainLooper()).postDelayed(
            {
                if (mAuth.currentUser != null)
                    startActivity(Intent(applicationContext, VendorMainActivity::class.java))
                else
                    startActivity(Intent(applicationContext, VendorLoginActivity::class.java))
            },
            2500
        )

    }


}