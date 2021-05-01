package com.devdhruv.ecommerce.viewModel

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devdhruv.ecommerce.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import java.text.SimpleDateFormat
import java.util.*

class VendorMenuViewModel: ViewModel() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val user = auth.currentUser

    private val firebaseStorage: FirebaseStorage = FirebaseStorage.getInstance()
    private val storageReference: StorageReference = firebaseStorage.reference
    private val imageReference: StorageReference = storageReference.child("images")


    private var _imageClicked =  MutableLiveData<Int?>()
    val imageClicked: LiveData<Int?> get() = _imageClicked

    private var _blankFields = MutableLiveData<Boolean>()
    val blankFields: LiveData<Boolean?>  get() = _blankFields

    private var _errorOccurred = MutableLiveData<String>()
    val errorOccurred: LiveData<String?> get() = _errorOccurred

    private val defaultUri: Uri = Uri.parse("android.resource://com.devdhruv.ecommerce/" + R.drawable.background_image)

    var productOneUri = MutableLiveData(defaultUri)
    var productTwoUri = MutableLiveData(defaultUri)
    var productThreeUri = MutableLiveData(defaultUri)

    lateinit var downloadOneUri: Uri
    lateinit var downloadTwoUri: Uri
    lateinit var downloadThreeUri: Uri

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

    private fun updateErrorMessage(errorMessage: String){
        _errorOccurred.value = errorMessage
        _blankFields.value = _blankFields.value != true
    }

    var imageUploadSuccess: Boolean = true
    var dataUploadSuccess: Boolean = true

    private fun uploadImage(imageNumber: Int){

        if (imageNumber == 4) return

        val fileName: String = user?.uid + "_" + SimpleDateFormat("yyyyMMdd_HHmmss").format(Date()) + imageNumber.toString()
        val fileReference: StorageReference = imageReference.child(fileName)
        val uploadTask: UploadTask

        when (imageNumber){
            1 -> uploadTask = productOneUri.value?.let { fileReference.putFile(it) }!!
            2 -> uploadTask = productTwoUri.value?.let { fileReference.putFile(it) }!!
            else -> uploadTask = productTwoUri.value?.let { fileReference.putFile(it)}!!
        }

        uploadTask.addOnSuccessListener {
            when (imageNumber) {
                1 -> {
                    downloadOneUri = it.uploadSessionUri!!
                    productName.value = it.uploadSessionUri.toString()
                }
                2 -> downloadTwoUri = it.uploadSessionUri!!
                else -> downloadThreeUri = it.uploadSessionUri!!
            }
            uploadImage(imageNumber + 1)
        }.addOnFailureListener {
                updateErrorMessage(it.message.toString())
                imageUploadSuccess = false
            }
    }

    private fun uploadData(){



    }

    fun onClickUpload(){
        if (checkFields()){
            uploadImage(1)
            if (imageUploadSuccess){
                uploadData()
                if (dataUploadSuccess){
                    updateErrorMessage("Upload Successful")
                }
            }
        }
        else{
            updateErrorMessage("Empty Fields")
        }
    }

}