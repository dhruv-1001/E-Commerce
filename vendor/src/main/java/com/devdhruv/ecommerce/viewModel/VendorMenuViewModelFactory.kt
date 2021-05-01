package com.devdhruv.ecommerce.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class VendorMenuViewModelFactory: ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VendorMenuViewModel::class.java)){
            return VendorMenuViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}