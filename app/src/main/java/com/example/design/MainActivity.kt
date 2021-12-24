package com.example.design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.design.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data:List<String> = listOf(
            "android.resource://com.example.design/drawable/image1",
            "android.resource://com.example.design/drawable/image2",
            "android.resource://com.example.design/drawable/image3",
            "android.resource://com.example.design/drawable/image4",
            "android.resource://com.example.design/drawable/image5"
        )
        val adapter = AddImageRvAdapter()
        adapter.updateData(data)
        binding.addImageRV.adapter = adapter

    }
}