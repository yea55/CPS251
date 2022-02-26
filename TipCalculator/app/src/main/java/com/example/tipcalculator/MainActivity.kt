package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tipcalculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun calcTip(view: View){
        if(binding.billText.text.isNotEmpty()){
            val billVal = binding.billText.text.toString().toFloat()
            val percent10 = billVal * 1.1
            val percent15 = billVal * 1.15
            val percent20 = billVal * 1.2
            val outputTxt = getString(R.string.tip_output_header) + getString(R.string.percent10) + "%.2f".format(percent10) + getString(R.string.percent15) + "%.2f".format(percent15) + getString(R.string.percent20) + "%.2f".format(percent20)
            //I hate the line above this
            binding.outputText.text = outputTxt
        }else{
            binding.outputText.text = getString(R.string.blank_notice)
        }

    }
}