package com.oa.sessiontask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.oa.sessiontask.databinding.ActivityMainBinding
import com.oa.sessiontask.Adapters.StoresAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var storeRv: RecyclerView
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getStoresList()
        viewModel.storeList.observe(this){
            storeRv = binding.storesRv
            val storesAdapter = StoresAdapter()
            storesAdapter.setList(it)
            storeRv.adapter = storesAdapter


        }


    Toast.makeText(this,"Toast",Toast.LENGTH_SHORT).show()
    }
}