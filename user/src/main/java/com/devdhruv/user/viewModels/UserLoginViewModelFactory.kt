package com.devdhruv.user.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UserLoginViewModelFactory: ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserLoginViewModel::class.java)){
            return UserLoginViewModel() as T
        }
        throw IllegalAccessError("Unknown ViewModel Class")
    }

}