package com.devdhruv.ecommerce.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth

class VendorLoginVIewModelFactory(
    private val auth: FirebaseAuth
): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VendorLoginViewModel::class.java)){
            return VendorLoginViewModel(auth) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}