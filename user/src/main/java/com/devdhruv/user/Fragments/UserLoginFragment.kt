package com.devdhruv.user.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.devdhruv.user.Activity.UserMainActivity
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

        binding.userLoginViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.navigateToRegister.observe(viewLifecycleOwner, {
            findNavController().navigate(R.id.action_userLoginFragment_to_userRegisterFragment)
        })

        viewModel.navigateToMainActivity.observe(viewLifecycleOwner,{
            if (it == true)
                startActivity(Intent(activity, UserMainActivity::class.java))
        })

        return binding.root
    }

}