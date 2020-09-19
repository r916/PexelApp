package com.example.pexelapp.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pexelapp.R
import com.example.pexelapp.model.Pexels
import kotlinx.android.synthetic.main.item_photo_in_grid.view.*

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private val differCallBack = object : DiffUtil.ItemCallback<Pexels>() {
        override fun areItemsTheSame(oldItem: Pexels, newItem: Pexels): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Pexels, newItem: Pexels): Boolean {
            // Might throw an error....not sure
            return oldItem.id == newItem.id
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_photo_in_grid,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val image = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(image.url).into(photo_iv)
        }
    }
}