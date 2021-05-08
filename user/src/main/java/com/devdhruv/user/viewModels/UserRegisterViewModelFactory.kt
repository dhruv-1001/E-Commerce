package com.devdhruv.user.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UserRegisterViewModelFactory : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserRegisterViewModel::class.java)) {
            return UserRegisterViewModel() as T
        }
        throw IllegalAccessError("Unknown ViewModel Class")
    }
}