package com.devdhruv.ecommerce.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.devdhruv.ecommerce.databinding.ActivityVendorLoginBinding
import com.devdhruv.ecommerce.viewModel.VendorLoginVIewModelFactory
import com.devdhruv.ecommerce.viewModel.VendorLoginViewModel
import com.google.firebase.auth.FirebaseAuth

class VendorLoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityVendorLoginBinding = ActivityVendorLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        val viewModelFactory = VendorLoginVIewModelFactory(auth)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(VendorLoginViewModel::class.java)

        binding.vendorLoginViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.navigateToUpload.observe(this, {
            if (it == true){
                Log.d("Navigating", "Login to Upload")
                startActivity(Intent(applicationContext, VendorMainActivity::class.java))
            }
        })

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}