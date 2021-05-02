package com.devdhruv.user.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.devdhruv.user.R
import com.devdhruv.user.databinding.FragmentUserLoginBinding
import com.devdhruv.user.viewModels.UserLoginViewModel
import com.devdhruv.user.viewModels.UserLoginViewModelFactory

class UserLoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentUserLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_user_login, container, false
        )

        val viewModelFactory = UserLoginViewModelFactory()
        val viewModel = ViewModelProvider(this, viewModelFactory).get(UserLoginViewModel::class.java)



        return binding.root
    }

}