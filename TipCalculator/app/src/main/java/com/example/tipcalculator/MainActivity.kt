package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun calcTip(view: View){
        if(billText.text.isNotEmpty()){
            val billVal = billText.text.toString().toFloat()
            val percent10 = billVal * 1.1
            val percent15 = billVal * 1.15
            val percent20 = billVal * 1.2
            outputText.text =
                "Tip amounts are as follows:\n\n10%: $$percent10\n15%: $$percent15\n20%: $$percent20"
        }else{
            outputText.text = "Please Enter A Bill Amount"
        }

    }
}