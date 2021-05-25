package com.example.mydemoapplication.Main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mydemoapplication.R
import com.example.mydemoapplication.databinding.FavoriteItemBinding
import com.example.mydemoapplication.databinding.MainGridViewItemBinding
import com.example.mydemoapplication.favorite.FavoriteItem
import kotlinx.android.synthetic.main.main_grid_view_item.view.*

class MainAdapter(
    private var exampleList: List<ExampleItem>,
    private val listener: OnItemClickListener
    ) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {



    var exampleListFilter = ArrayList<ExampleItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val binding =
            MainGridViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val currentItem = exampleList[position]
        if (currentItem != null) {
            holder.bind(currentItem)
        }
        //holder.textView.setText(getTextFromId(position))

    }



    override fun getItemCount()= exampleList.size

    inner class MainViewHolder(private val binding: MainGridViewItemBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        fun bind(main: ExampleItem) {
            binding.apply {
                Glide.with(itemView)
                    .load(main.imageResource)
                    .into(imageGridView)
                //catalogText.setText (getTextFromId(position))
                catalogText.setText(getTextFromId(absoluteAdapterPosition))

            }
        }

        //val textView: TextView = itemView.catalog_text

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = getAbsoluteAdapterPosition()
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }


    private fun getTextFromId(position: Int): String? {
        var catalog = "Sản phẩm"
        catalog = when (position) {
            0 -> "Gạo & mì các loại"
            1 -> "Thực phẩm đông lạnh"
            2 -> "Gia vị"
            3 -> "Rau, củ, quả"
            4 -> "Đồ khô & ăn vặt"
            5 -> "Thực phẩm đóng hộp"
            else -> ""
        }
        return catalog
    }


}