package com.example.design

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.design.model.WeightAndPrice

class WeightSelectableRvAdapter(private val data:List<WeightAndPrice>, val onItemClicked:(Int)->Unit):RecyclerView.Adapter<WeightSelectableRvAdapter.ViewHolder>() {

    var checkedItem:Int = -1

    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val item:WeightSelectable = view.findViewById(R.id.item)
        fun bind(weightAndPrice: WeightAndPrice, position: Int, onItemClicked:(Int)->Unit){
            item.setMainHeading(weightAndPrice.title)
            item.setSubHeading(weightAndPrice.detail)
            item.setCurrency(weightAndPrice.currency)
            item.setPrice(weightAndPrice.price.toString())
            item.setOnClickListener {
                checkedItem = position
                onItemClicked(checkedItem)
                notifyDataSetChanged()
            }
            item.isChecked = position == checkedItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.weight_selectable_rv_item, parent, false)
        return ViewHolder(root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val weightAndPrice = data[position]
        holder.bind(weightAndPrice, position, onItemClicked)
    }

    override fun getItemCount(): Int {
        return  data.size
    }
}