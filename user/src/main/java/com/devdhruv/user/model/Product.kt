package com.devdhruv.user.model

data class Product(
    var category: String = "",
    var deliveryCharge: Int = -1,
    var gstAmount: Int = -1,
    var imageOneUri:String = "",
    var imageThreeUri:String = "",
    var imageTwoUri:String = "",
    var offer: Int = -1,
    var priceAmount: Int = -1,
    var productName: String = ""
)
