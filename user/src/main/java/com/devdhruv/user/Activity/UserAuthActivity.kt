package com.devdhruv.user.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devdhruv.user.R

class UserAuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_auth)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish();
    }

}