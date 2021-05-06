package com.devdhruv.user.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.devdhruv.user.R
import com.devdhruv.user.databinding.FragmentProductBinding

class ProductFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentProductBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_product, container, false
        )

        return binding.root
    }
}