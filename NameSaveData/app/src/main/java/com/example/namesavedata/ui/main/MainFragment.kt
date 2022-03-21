package com.example.namesavedata.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.namesavedata.R
import androidx.lifecycle.Observer
//import androidx.lifecycle:lifecycle-extensions
import androidx.databinding.DataBindingUtil
import com.example.namesavedata.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    //lateinit var binding: MainFragmentBinding
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //return inflater.inflate(R.layout.main_fragment, container, false)
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        //binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        //binding.setLifecycleOwner (this )

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.outputText.text =viewModel.getNamesList().toString()
        val theObserver = Observer<String>{
                namesList -> binding.outputText.text = namesList.toString()


        }


        viewModel.getNames().observe(viewLifecycleOwner, theObserver)
        binding.button.setOnClickListener{
            if(binding.nameTextBox.text.isNotEmpty()){
                viewModel.addName(binding.nameTextBox.text.toString())
                binding.outputText.text=viewModel.getNamesList().toString()
            }
        }


        // TODO: Use the ViewModel
    }
    //fun addName(){}

}