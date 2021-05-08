package com.devdhruv.user.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class UserRegisterViewModel : ViewModel() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    private var _navigateToLogin = MutableLiveData<Boolean>()
    val navigateToLogin: LiveData<Boolean> get() = _navigateToLogin

    private var _navigateToMainActivity = MutableLiveData(false)
    val navigateToMainActivity: LiveData<Boolean> get() = _navigateToMainActivity

    val emailId = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    fun checkFields(): Boolean {
        if (emailId.value.isNullOrBlank()) return false
        if (password.value.isNullOrBlank()) return false
        return true
    }

    fun register() {
        if (checkFields()) {
            auth.createUserWithEmailAndPassword(emailId.value.toString(), emailId.value.toString())
                .addOnSuccessListener {
                    _navigateToMainActivity.value = true
                }
        }
    }

    fun onNavigateClick() {
        _navigateToLogin.value = _navigateToLogin.value == false
    }

}