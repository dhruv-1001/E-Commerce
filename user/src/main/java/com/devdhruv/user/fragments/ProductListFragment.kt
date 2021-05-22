package com.devdhruv.user.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.devdhruv.user.R
import com.devdhruv.user.databinding.FragmentProductListBinding
import com.devdhruv.user.viewModels.ProductListViewModel
import com.devdhruv.user.viewModels.ProductListViewModelFactory

class ProductListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentProductListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_product_list, container, false
        )

        val viewModelFactory = ProductListViewModelFactory()
        val viewModel = ViewModelProvider(this, viewModelFactory).get(ProductListViewModel::class.java)

        viewModel.getProductData()

        viewModel.products.observe(viewLifecycleOwner, {
            for (i in it){
                Log.d("Product Name", i.productName)
            }
        })

        return binding.root
    }
}