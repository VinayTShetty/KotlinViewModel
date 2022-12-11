package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewmodel.viewModel.CountryViewModel

class MainActivity : AppCompatActivity() {

    lateinit var countryAdapter: CountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.userdata_list)
        initRecycleView()
        initViewModel()
    }

    private fun initRecycleView() {
        val countryRecyclerview = findViewById<RecyclerView>(R.id.countryLisRecycleView)
        countryRecyclerview.layoutManager = LinearLayoutManager(this)
        countryAdapter=CountryAdapter(this)
        countryRecyclerview.adapter=countryAdapter
    }

    private fun initViewModel(){
        val viewModel: CountryViewModel =ViewModelProvider(this).get(CountryViewModel::class.java)

        viewModel.getLiveDataObserver().observe(this, Observer {
            if(it!=null){
                countryAdapter.setCountryList(it)
                countryAdapter.notifyDataSetChanged()
            }else{
                Toast.makeText(this,"Error Fetching List",Toast.LENGTH_LONG).show()
            }
        })
        viewModel.makeAPICall()
    }
}