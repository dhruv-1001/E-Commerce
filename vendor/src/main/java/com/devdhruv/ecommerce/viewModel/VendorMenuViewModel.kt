package com.devdhruv.ecommerce.viewModel

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devdhruv.ecommerce.R
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class VendorMenuViewModel(
    private val firebaseStorage: FirebaseStorage,
    private val storageReference: StorageReference
): ViewModel() {

    private var _imageClicked =  MutableLiveData<Int?>()
    val imageClicked: LiveData<Int?> get() = _imageClicked

    private val defaultUri: Uri = Uri.parse("android.resource://com.devdhruv.ecommerce/" + R.drawable.background_image)

    var productOneUri = MutableLiveData(defaultUri)
    var productTwoUri = MutableLiveData(defaultUri)
    var productThreeUri = MutableLiveData(defaultUri)

    fun changeImage(imageUri: Uri, selectedImage: Int) {
        when (selectedImage){
            1 -> productOneUri.value = imageUri
            2 -> productTwoUri.value = imageUri
            else -> productThreeUri.value = imageUri
        }
    }

    fun onImageUploadClick(index: Int){
        _imageClicked.value = index
    }


    private fun checkFields(): Boolean{
        return true
    }

    fun onClickUpload(){
        if (checkFields()){

        }
    }

}