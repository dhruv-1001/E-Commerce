package com.devdhruv.ecommerce

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("imageUri")
fun bindImage(imgView: ImageView, imgUri: Uri){
    imgView.setImageURI(imgUri)
}

