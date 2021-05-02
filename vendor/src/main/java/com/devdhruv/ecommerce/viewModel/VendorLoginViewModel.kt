package com.devdhruv.ecommerce.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class VendorLoginViewModel(
    private val auth: FirebaseAuth
): ViewModel() {

    private var _navigateToUpload =  MutableLiveData<Boolean?>()
    val navigateToUpload: LiveData<Boolean?> get() = _navigateToUpload

    val emailId = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    fun checkFields(): Boolean{
        if (emailId.value.isNullOrBlank()) return false
        if (password.value.isNullOrBlank()) return false
        return true
    }

    fun onLoginClick(){

        if(!checkFields()) return
        auth.signInWithEmailAndPassword(emailId.value.toString(), password.value.toString())
            .addOnSuccessListener {
                _navigateToUpload.value = true
            }
    }

}