package com.devdhruv.user.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class UserLoginViewModel: ViewModel() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    private var _navigateToRegister = MutableLiveData<Boolean>()
    val navigateToRegister: LiveData<Boolean> get() = _navigateToRegister

    private var _navigateToMainActivity = MutableLiveData(false)
    val navigateToMainActivity: LiveData<Boolean> get() = _navigateToMainActivity

    val emailId = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    fun checkFields(): Boolean{
        if (emailId.value.isNullOrBlank()) return false
        if (password.value.isNullOrBlank()) return false
        return true
    }

    fun login(){
        if (checkFields()){
            auth.signInWithEmailAndPassword(emailId.value.toString(), password.value.toString())
                .addOnSuccessListener {
                    _navigateToMainActivity.value = true
                }
        }
    }

    fun onNavigateClick(){
        _navigateToRegister.value = _navigateToRegister.value == false
    }

}