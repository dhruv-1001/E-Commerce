package com.devdhruv.ecommerce.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.devdhruv.ecommerce.R
import com.devdhruv.ecommerce.databinding.FragmentVendorMenuBinding

class VendorMenuFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentVendorMenuBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_vendor_menu, container, false
        )


        return binding.root
    }

}