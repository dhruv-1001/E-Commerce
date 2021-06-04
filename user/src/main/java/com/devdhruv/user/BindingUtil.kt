package com.devdhruv.user

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.devdhruv.user.model.Product
import com.squareup.picasso.Picasso

@BindingAdapter("productName")
fun TextView.productName(item: Product){
    item.let{
        text = item.productName
    }
}

@BindingAdapter("produceCategory")
fun TextView.productCategory(item: Product){
    item.let{
        text = item.category
    }
}

@BindingAdapter("productPrice")
fun TextView.productPrice(item: Product){
    item.let{
        text = item.priceAmount.toString()
    }
}

//@BindingAdapter("productImage")
//fun productImage(imgView: ImageView, item: Product){
//
//    Picasso.get()
//        .load(item.imageOneUri.toUri())
//        .placeholder(R.drawable.background_image)
//        .fit()
//        .error(R.drawable.button_background)
//        .centerCrop()
//        .into(imgView)
//
//}