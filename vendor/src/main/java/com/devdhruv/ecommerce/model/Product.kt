package com.devdhruv.ecommerce.model

import android.net.Uri

data class Product(
    var category: String = "",
    var productName: String = "",
    var priceAmount: Int = -1,
    var gstAmount: Int = -1,
    var deliveryCharge: Int = -1,
    var offer: Int = -1,
    var imageOneUri: String = "",
    var imageTwoUri: String = "",
    var imageThreeUri: String = ""
)
