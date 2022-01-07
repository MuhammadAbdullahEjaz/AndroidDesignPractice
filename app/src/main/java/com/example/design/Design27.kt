package com.example.design
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.design.databinding.FragmentDesign27Binding
import com.example.design.model.WeightAndPrice

class Design27 : Fragment() {

    private lateinit var binding: FragmentDesign27Binding
    private var selectedWeight = -1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_design27, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.appBarLayout.toolBarB.setOnClickListener {
            view.findNavController().popBackStack()
        }

        binding.nextB.setOnClickListener {
            val action = Design27Directions.actionDesign27ToDesign28()
            view.findNavController().navigate(action)
        }

        val weightPriceData = listOf(
            WeightAndPrice(
                "Light item",
                "Smaller garments & jewellery fits into this category (up to 0,5 kg)",
                "DKK",
                42
            ),
            WeightAndPrice(
                "Regular item",
                "Most garments fit into this category (up to 1 kg)",
                "DKK",
                47
            ),
            WeightAndPrice(
                "Medium item",
                "Usually jackets, shoes and items that are a little bit heavier (up to 3 kg)",
                "DKK",
                53
            ),
            WeightAndPrice(
                "Heavy item",
                "Usually coats or other heavy items. (up to 10 kg)",
                "DKK",
                68
            )
        )
        binding.weightSelectAbleRV.adapter = WeightSelectableRvAdapter(weightPriceData){
            if(it != -1){
                Log.d("fetch", "option selected is ${weightPriceData[it].title}")
                selectedWeight = it
                binding.nextB.isEnabled = true
            }
        }
        binding.enableDeliveryS.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.packageSpecsCL.visibility = View.VISIBLE
                binding.enableDeliveryTV.visibility = View.GONE
                binding.selfTransferS.isChecked = false
                binding.nextB.isEnabled = selectedWeight != -1
            } else {
                binding.packageSpecsCL.visibility = View.GONE
                binding.enableDeliveryTV.visibility = View.VISIBLE
                binding.nextB.isEnabled = false
            }
        }
        binding.selfTransferS.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.enableDeliveryS.isChecked = false
                binding.nextB.isEnabled = true
            } else {
                binding.nextB.isEnabled = false
            }
        }
        if (binding.enableDeliveryS.isChecked) {
            binding.packageSpecsCL.visibility = View.VISIBLE
            binding.enableDeliveryTV.visibility = View.GONE
        } else {
            binding.packageSpecsCL.visibility = View.GONE
            binding.enableDeliveryTV.visibility = View.VISIBLE
        }
    }
}