package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //binding = DataBindingUtil.inflate(inflater,R.layout.fragment_welcome, container, false)
        binding = FragmentWelcomeBinding.inflate( inflater, container, false)
        binding.nextButton.setOnClickListener { view:View ->
            Navigation.findNavController(view).navigate(R.id.action_welcomeFragment_to_instructionFragment)
        }
        return binding.root
    }

}