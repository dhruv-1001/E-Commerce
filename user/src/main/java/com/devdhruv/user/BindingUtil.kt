package com.devdhruv.user

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.devdhruv.user.model.Product

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