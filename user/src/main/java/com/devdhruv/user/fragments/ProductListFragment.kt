package com.devdhruv.user.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.devdhruv.user.R
import com.devdhruv.user.adapters.ProductClickListener
import com.devdhruv.user.adapters.ProductListAdapter
import com.devdhruv.user.databinding.FragmentProductListBinding
import com.devdhruv.user.model.Product
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

        binding.productListViewModel = viewModel

        val productAdapter = ProductListAdapter(ProductClickListener {
            product -> viewModel.setSelectedProduct(product)
        })

        binding.productList.adapter = productAdapter

        viewModel.getProductData()

        viewModel.products.observe(viewLifecycleOwner, {
            it.let {
                productAdapter.submitList(it)
            }
        })

        viewModel.navigateToProduct.observe(viewLifecycleOwner, {
            findNavController().navigate(R.id.action_productListFragment_to_productFragment)
        })

        return binding.root
    }

}