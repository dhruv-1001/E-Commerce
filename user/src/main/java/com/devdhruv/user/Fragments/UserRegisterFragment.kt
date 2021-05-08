package com.devdhruv.user.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.devdhruv.user.Activity.UserMainActivity
import com.devdhruv.user.R
import com.devdhruv.user.databinding.FragmentUserRegisterBinding
import com.devdhruv.user.viewModels.UserRegisterViewModel
import com.devdhruv.user.viewModels.UserRegisterViewModelFactory

class UserRegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentUserRegisterBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_user_register, container, false
        )

        val viewModelFactory = UserRegisterViewModelFactory()
        val viewModel =
            ViewModelProvider(this, viewModelFactory).get(UserRegisterViewModel::class.java)

        binding.userRegisterViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.navigateToLogin.observe(viewLifecycleOwner, {
            findNavController().navigate(R.id.action_userRegisterFragment_to_userLoginFragment)
        })

        viewModel.navigateToMainActivity.observe(viewLifecycleOwner, {
            if (it == true)
                startActivity(Intent(activity, UserMainActivity::class.java))
        })

        return binding.root
    }

}