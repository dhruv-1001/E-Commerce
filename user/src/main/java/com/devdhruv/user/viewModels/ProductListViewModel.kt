package com.devdhruv.user.viewModels

import androidx.lifecycle.ViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class ProductListViewModel: ViewModel() {

    val database: DatabaseReference = FirebaseDatabase.getInstance().reference

}