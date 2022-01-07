package com.example.design

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import com.example.design.databinding.FragmentDesign7Binding


class Design7 : Fragment() {

    private lateinit var binding:FragmentDesign7Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_design7, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
        binding.nextB.setOnClickListener {
            val action = Design7Directions.actionDesign7ToDesign27()
            view.findNavController().navigate(action)
        }
    }

}