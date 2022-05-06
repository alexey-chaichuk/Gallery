package com.example.gallery.ui.feature.picturelist.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.gallery.R

class PictureListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var pics = listOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PictureDataViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(R.layout.item_picture, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is PictureDataViewHolder -> {
                holder.onBind(pics[position])
            }
        }
    }

    override fun getItemCount(): Int = pics.size

    fun bindSignals(newPics : List<String>) {
        pics = newPics
        notifyDataSetChanged()
    }
}

private class PictureDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val pic: ImageView = itemView.findViewById(R.id.pic_view)

    fun onBind(picPath: String) {
        pic.load(picPath)
    }
}