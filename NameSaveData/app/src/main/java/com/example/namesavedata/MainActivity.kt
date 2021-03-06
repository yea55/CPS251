package com.example.namesavedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.namesavedata.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

    //fun addName(view: View) {}
}