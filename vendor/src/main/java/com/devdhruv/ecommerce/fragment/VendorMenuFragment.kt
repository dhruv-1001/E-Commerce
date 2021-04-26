package com.devdhruv.ecommerce.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.devdhruv.ecommerce.R
import com.devdhruv.ecommerce.databinding.FragmentVendorMenuBinding
import com.devdhruv.ecommerce.viewModel.VendorMenuViewModel
import com.devdhruv.ecommerce.viewModel.VendorMenuViewModelFactory

class VendorMenuFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentVendorMenuBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_vendor_menu, container, false
        )

        val viewModelFactory = VendorMenuViewModelFactory()
        val viewModel = ViewModelProvider(this, viewModelFactory).get(VendorMenuViewModel::class.java)

        binding.vendorMenuViewModel = viewModel
        binding.lifecycleOwner = this



        return binding.root
    }

}