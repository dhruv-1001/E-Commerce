package com.devdhruv.ecommerce.viewModel

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devdhruv.ecommerce.R

class VendorMenuViewModel: ViewModel() {

    private var _imageClicked =  MutableLiveData<Int?>()
    val imageClicked: LiveData<Int?> get() = _imageClicked

    var productOneImage: Uri = Uri.parse("android.resource://com.devdhruv.ecommerce/" + R.drawable.background_image)

    var productTwoImage: Uri = Uri.parse("android.resource://com.devdhruv.ecommerce/" + R.drawable.background_image)

    var productThreeImage: Uri = Uri.parse("android.resource://com.devdhruv.ecommerce/" + R.drawable.background_image)

    fun changeImage(imageUri: Uri, selectedImage: Int) {
        when (selectedImage){
            1 -> productOneImage = imageUri
            2 -> productTwoImage = imageUri
            else -> productThreeImage = imageUri
        }
    }

    fun onImageUploadClick(index: Int){
        _imageClicked.value = index
    }

    fun onClickUpload(){

    }

}