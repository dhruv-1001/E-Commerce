package com.devdhruv.user.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.devdhruv.user.R
import com.devdhruv.user.databinding.FragmentProductBinding
import com.devdhruv.user.viewModels.ProductListViewModel
import com.devdhruv.user.viewModels.ProductListViewModelFactory

class ProductFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val binding: FragmentProductBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_product, container, false
        )

        val viewModelFactory = ProductListViewModelFactory()
        val viewModel = ViewModelProvider(this, viewModelFactory).get(ProductListViewModel::class.java)

        binding.productListViewModel = viewModel

        Log.d("Product", viewModel.selectedProduct.value?.productName.toString())

        return binding.root
    }

}