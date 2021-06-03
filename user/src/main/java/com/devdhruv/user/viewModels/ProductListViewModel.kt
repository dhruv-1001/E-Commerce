package com.devdhruv.user.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devdhruv.user.model.Product
import com.google.firebase.database.FirebaseDatabase


class ProductListViewModel: ViewModel() {

    var products: MutableLiveData<List<Product>> = MutableLiveData()
    var selectedProduct: MutableLiveData<Product> = MutableLiveData()

    private var _navigateToProduct = MutableLiveData<Boolean>()
    val navigateToProduct: LiveData<Boolean> get() = _navigateToProduct

    fun setSelectedProduct(product: Product){
        selectedProduct.value = product
        _navigateToProduct.value = _navigateToProduct.value == false
    }

    fun getProductData(){
        Log.d("Fetching Data", "From Database")
        if (products.value == null){
            FirebaseDatabase.getInstance().getReference("products").get().addOnCompleteListener { task ->
                var temp: List<Product>? = null
                if (task.isSuccessful){
                    val result = task.result
                    result?.let {
                        temp = result.children.map { snapShot->
                            snapShot.getValue(Product::class.java)!!
                        }
                    }
                }
                products.value = temp
            }
        }
    }
}

