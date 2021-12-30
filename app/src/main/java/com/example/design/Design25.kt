package com.example.design

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.design.databinding.FragmentDesign27Binding

class Design25 : Fragment() {

    private lateinit var binding:FragmentDesign27Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_design27, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolBarB.setOnClickListener {
            view.findNavController().popBackStack()
        }
        binding.enableDeliveryS.setOnCheckedChangeListener { _, isChecked ->
            run {
                if (isChecked) {
                    binding.packageSpecsCL.visibility = View.VISIBLE
                    binding.enableDeliveryTV.visibility = View.GONE
                    binding.selfTransferS.isChecked = false
                } else {
                    binding.packageSpecsCL.visibility = View.GONE
                    binding.enableDeliveryTV.visibility = View.VISIBLE
                }
            }
        }
        binding.selfTransferS.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked){
                binding.enableDeliveryS.isChecked = false
                binding.nextB.isEnabled = true
            }else{
                binding.nextB.isEnabled = false
            }
        }
        if(binding.enableDeliveryS.isChecked){
            binding.packageSpecsCL.visibility = View.VISIBLE
            binding.enableDeliveryTV.visibility = View.GONE
        }else{
            binding.packageSpecsCL.visibility = View.GONE
            binding.enableDeliveryTV.visibility = View.VISIBLE
        }
    }
}