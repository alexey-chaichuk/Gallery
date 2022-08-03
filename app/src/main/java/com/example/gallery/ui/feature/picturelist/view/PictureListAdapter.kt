package com.example.gallery.ui.feature.picturelist.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.gallery.R

class PictureListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var pics = mutableListOf<String>()

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
                with(holder) {
                    onBind(pics[position])
                    itemView.setOnClickListener {
                        it.setOnClickListener(null)
                        remove(adapterPosition)
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int = pics.size

    fun bindPics(newPics : List<String>) {
        pics = newPics.toMutableList()
        notifyDataSetChanged()
    }

    fun remove(position: Int) {
        pics.removeAt(position)
        notifyItemRemoved(position)
    }
}

private class PictureDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val pic: ImageView = itemView.findViewById(R.id.pic_view)

    fun onBind(picPath: String) {
        pic.load(picPath) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}