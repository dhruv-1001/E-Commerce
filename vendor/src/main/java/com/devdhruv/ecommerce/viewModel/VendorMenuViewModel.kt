package com.devdhruv.ecommerce.viewModel

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devdhruv.ecommerce.R
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class VendorMenuViewModel(
    private val firebaseStorage: FirebaseStorage,
    private val storageReference: StorageReference
): ViewModel() {

    private var _imageClicked =  MutableLiveData<Int?>()
    val imageClicked: LiveData<Int?> get() = _imageClicked

    private var _blankFields = MutableLiveData<Boolean>()
    val blankFields: LiveData<Boolean?>  get() = _blankFields

    private val defaultUri: Uri = Uri.parse("android.resource://com.devdhruv.ecommerce/" + R.drawable.background_image)

    var productOneUri = MutableLiveData(defaultUri)
    var productTwoUri = MutableLiveData(defaultUri)
    var productThreeUri = MutableLiveData(defaultUri)

    var category = MutableLiveData<String>()
    var productName = MutableLiveData<String>()
    var priceAmt = MutableLiveData<String>()
    var gstAmt = MutableLiveData<String>()
    var deliveryCharge = MutableLiveData<String>()
    var offer = MutableLiveData<String>()

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

        if (productOneUri.value == defaultUri
            || productTwoUri.value == defaultUri
            || productThreeUri.value == defaultUri
            || category.value.isNullOrBlank()
            || productName.value.isNullOrBlank()
            || priceAmt.value.isNullOrBlank()
            || gstAmt.value.isNullOrBlank()
            || deliveryCharge.value.isNullOrBlank()
            || offer.value.isNullOrBlank()){
            return false
        }
        return true
    }

    private fun updateBlankFields(){
        _blankFields.value = _blankFields.value != true
    }

    fun onClickUpload(){
        if (checkFields()){

        }
        else{
            updateBlankFields()
        }
    }

}