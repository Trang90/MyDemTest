package com.example.mydemoapplication.catalog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mydemoapplication.R
import com.example.mydemoapplication.cart.CartItem
import com.example.mydemoapplication.databinding.CatalogItemBinding
import kotlinx.android.synthetic.main.catalog_item.view.*

class CatalogAdapter(
    private val catalogList: List<CatalogItem>,
    private val listener: CatalogFragment
) : RecyclerView.Adapter<CatalogAdapter.CatalogViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        val binding =
            CatalogItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatalogViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        val currentItem = catalogList[position]
        if (currentItem != null) {
            holder.bind(currentItem)
        }

        holder.imageView2.setImageResource(R.drawable.timden24)

    }

    override fun getItemCount() = catalogList.size

    inner class CatalogViewHolder(private val binding: CatalogItemBinding) : RecyclerView.ViewHolder (binding.root), View.OnClickListener {

        fun bind(catalog: CatalogItem) {
            binding.apply {
                Glide.with(itemView)
                    .load(catalog.imageResource)
                    .into(anhsanpham)
                tensanpham.text = catalog.textTenSanPham
                giasanpham.text = catalog.textGiaSanPham
                giakhuyenmai.text = catalog.textGiaKhuyenMai
            }
        }

        val imageView2: ImageView = itemView.image_view_tim


        init {itemView.setOnClickListener(this)}

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

}


