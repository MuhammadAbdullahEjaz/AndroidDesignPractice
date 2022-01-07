package com.example.design

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.design.databinding.FragmentDesign28Binding
import com.google.android.material.textfield.TextInputEditText

class Design28 : Fragment() {

    private lateinit var binding:FragmentDesign28Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_design28, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var regNoValidation = false
        var accountNoValidation = false
        checkDataValidation(binding.regNoTI, binding.accountNoTI)
        binding.appBarLayout.toolBarB.setOnClickListener {
            view.findNavController().popBackStack()
        }

        binding.saveB.setOnClickListener{
            binding.bankInfoEditGroup.visibility = View.GONE
            binding.saveB.visibility = View.GONE
            val regAccountInfo = getString(R.string.regAccountInfo,binding.regNoTI.text.toString(), binding.accountNoTI.text.toString())
            var formatedValue = "********************"
            if (regAccountInfo.length == 20) {
                formatedValue = regAccountInfo.replaceRange(2, 16, "**************")
            }
            binding.accountNoPrevTIL.editText?.setText(formatedValue)
            binding.accountNoPrevTIL.visibility = View.VISIBLE
            binding.previewAdB.visibility = View.VISIBLE
        }

        binding.previewAdB.setOnClickListener{
            val action =  Design28Directions.actionDesign28ToDesign30()
            view.findNavController().navigate(action)
        }

        binding.accountNoPrevTIL.setEndIconOnClickListener {
            binding.accountNoPrevTIL.visibility = View.GONE
            binding.previewAdB.visibility = View.GONE
            binding.bankInfoEditGroup.visibility = View.VISIBLE
            binding.saveB.visibility = View.VISIBLE
        }

        binding.regNoTI.doOnTextChanged{ text,_,_,_ ->
            regNoValidation = text?.length == 4
            setSaveBState(regNoValidation, accountNoValidation)
        }

        binding.accountNoTI.doOnTextChanged { text,_,_,_ ->
            accountNoValidation = text?.length == 16
            setSaveBState(regNoValidation, accountNoValidation)
        }
    }

    fun checkDataValidation(accountEditText: TextInputEditText, regEditText: TextInputEditText){
            setSaveBState(regEditText.length() == 4, accountEditText.length() == 16)
    }

    fun setSaveBState(regValidation:Boolean, accountValidation:Boolean){
        Log.d("fetch","$regValidation--$accountValidation")
        binding.saveB.isEnabled = regValidation && accountValidation
    }

}