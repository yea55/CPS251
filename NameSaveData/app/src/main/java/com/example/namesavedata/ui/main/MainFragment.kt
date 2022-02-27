package com.example.namesavedata.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.namesavedata.R
import androidx.lifecycle.Observer
import com.example.namesavedata.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //return inflater.inflate(R.layout.main_fragment, container, false)
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.button.setOnClickListener{
            if(binding.nameTextBox.text.isNotEmpty()){
                viewModel.addName(binding.nameTextBox.text.toString())
                binding.outputText.text=viewModel.getNames().toString()
            }
        }
        val theObserver = Observer<String>{
            names -> binding.outputText.text = names.toString()

        }
        viewModel.getNames().observe(viewLifecycleOwner, theObserver)

        // TODO: Use the ViewModel
    }
    //fun addName(){}

}