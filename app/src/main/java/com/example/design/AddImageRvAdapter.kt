package com.example.design

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class AddImageRvAdapter:RecyclerView.Adapter<AddImageRvAdapter.ItemCardView>() {

    private var imageData:List<String> = emptyList()

    class ItemCardView(view:View):RecyclerView.ViewHolder(view){
        val imageView:ImageView = view.findViewById(R.id.addImageIV)
        val cancalButton:MaterialButton = view.findViewById(R.id.addImageIVB)


        fun bind(imageSrc:String){
//            imageView.setBackgroundResource(R.drawable.image1)
            imageView.setImageURI(Uri.parse(imageSrc))
            cancalButton.setOnClickListener {
                Log.d("cross", "cancelled clicked")
            }
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