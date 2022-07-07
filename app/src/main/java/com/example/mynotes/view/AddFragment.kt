package com.example.mynotes.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mynotes.R
import com.example.mynotes.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: UserViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.addButton.setOnClickListener {
            getDataLive()
        }

        return binding.root
    }

    private fun isEntryValid(): Boolean {
        return viewModel.isEntryValid(
            binding.addFirstNameEt.text.toString(),
            binding.addLastNameEt.text.toString(),
            binding.addButton.text.toString()
        )
    }

    private fun getDataLive() {
        if(isEntryValid()){
        viewModel.addNewUser(
            binding.addFirstNameEt.text.toString(),
            binding.addLastNameEt.text.toString(),
            binding.addAgeEt.text.toString()
        )
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }

    }

}