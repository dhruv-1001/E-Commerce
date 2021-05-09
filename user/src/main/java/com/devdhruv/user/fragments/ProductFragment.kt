package com.devdhruv.user.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.devdhruv.user.R
import com.devdhruv.user.databinding.FragmentProductBinding
import com.devdhruv.user.viewModels.ProductViewModel
import com.devdhruv.user.viewModels.ProductViewModelFactory

class ProductFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentProductBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_product, container, false
        )

        val viewModelFactory = ProductViewModelFactory()
        val viewModel =
            ViewModelProvider(this, ProductViewModelFactory()).get(ProductViewModel::class.java)

        return binding.root
    }
}