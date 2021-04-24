package com.devdhruv.ecommerce.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.devdhruv.ecommerce.R
import com.devdhruv.ecommerce.databinding.FragmentVendorLoginBinding
import com.devdhruv.ecommerce.viewModel.VendorLoginVIewModelFactory
import com.devdhruv.ecommerce.viewModel.VendorLoginViewModel
import com.google.firebase.auth.FirebaseAuth

class VendorLoginFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentVendorLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_vendor_login, container, false
        )

        auth = FirebaseAuth.getInstance()
        if (auth.currentUser != null){
            navigate()
        }

        val viewModelFactory = VendorLoginVIewModelFactory(auth)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(VendorLoginViewModel::class.java)

        binding.vendorLoginViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.navigateToUpload.observe(viewLifecycleOwner, {
            if (it == true){
                Log.d("Navigating", "Login to Upload")
                navigate()
            }
        })

        return binding.root
    }

    private fun navigate(){
        findNavController().navigate(R.id.action_vendorLoginFragment_to_vendorUploadFragment)
    }

}