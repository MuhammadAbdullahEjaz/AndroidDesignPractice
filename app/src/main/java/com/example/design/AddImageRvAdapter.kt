package com.example.design

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class AddImageRvAdapter:RecyclerView.Adapter<AddImageRvAdapter.ItemCardView>() {

    private var imageData:List<String> = emptyList()

    class ItemCardView(view:View):RecyclerView.ViewHolder(view){
        val imageView:ImageView = view.findViewById(R.id.addImageIV)
        fun bind(imageSrc:String){
            imageView.setImageURI(Uri.parse(imageSrc))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCardView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.add_image_rv_item, parent, false)
        return ItemCardView(view)
    }

    override fun onBindViewHolder(holder: ItemCardView, position: Int) {
        val image = imageData[position]
        holder.bind(image)

    }

    override fun getItemCount(): Int {
        return imageData.size
    }

    fun updateData(data:List<String>?){
        imageData = data ?: emptyList()
        notifyDataSetChanged()
    }

}