package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var viewmodelProvider = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        var btnNumber = findViewById<Button>(R.id.btn_number)
        var txtViewNumber = findViewById<TextView>(R.id.textView_numberCount)
        txtViewNumber.text = viewmodelProvider.number.toString()
        btnNumber.setOnClickListener {
            viewmodelProvider.addnumber()
            txtViewNumber.text = viewmodelProvider.number.toString()
        }

    }
}