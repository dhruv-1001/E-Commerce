package com.devdhruv.ecommerce.fragment

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.util.Log
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
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference


class VendorMenuFragment : Fragment() {

    var selectedImage = 1

    lateinit var viewModel: VendorMenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentVendorMenuBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_vendor_menu, container, false
        )

        val viewModelFactory = VendorMenuViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(VendorMenuViewModel::class.java)

        binding.vendorMenuViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.imageClicked.observe(viewLifecycleOwner, {
            if (it != null) {
                selectedImage = it
            }
            choosePicture()
        })

        viewModel.blankFields.observe(viewLifecycleOwner, {
            Snackbar.make(requireView(), viewModel.errorOccurred.value.toString(), Snackbar.LENGTH_SHORT).show()
        })

        return binding.root
    }

    private fun choosePicture(){

        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, 1)

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK && data != null){
            viewModel.changeImage(data.data!!, selectedImage)
        }
    }

}