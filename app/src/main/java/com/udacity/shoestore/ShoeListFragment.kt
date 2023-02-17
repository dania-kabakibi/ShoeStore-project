package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.NewShoeItemBinding
import com.udacity.shoestore.models.Shoe


class ShoeListFragment : Fragment() {

    private val viewModel by activityViewModels<ShoeViewModel>()
    private lateinit var binding: FragmentShoeListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_list, container, false)
        binding.lifecycleOwner = this
        //viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)
        binding.floatingActionButton.setOnClickListener { view:View ->
            Navigation.findNavController(view).navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }

        viewModel.shoeList.observe(viewLifecycleOwner, Observer {
            shoeList ->
            for (shoe in shoeList) {
                val shoeItemBinding = NewShoeItemBinding.inflate(layoutInflater)
                shoeItemBinding.shoe = shoe
                binding.shoesListLinearLayout.addView(shoeItemBinding.root)
            }

        })

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
        return true
    }

}