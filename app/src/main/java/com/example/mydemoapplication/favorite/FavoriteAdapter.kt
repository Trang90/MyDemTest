package com.example.mydemoapplication.favorite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mydemoapplication.R
import com.example.mydemoapplication.catalog.CatalogItem
import com.example.mydemoapplication.databinding.CatalogItemBinding
import com.example.mydemoapplication.databinding.FavoriteItemBinding
import kotlinx.android.synthetic.main.cart_item.view.*
import kotlinx.android.synthetic.main.catalog_item.view.*
import kotlinx.android.synthetic.main.catalog_item.view.giakhuyenmai
import kotlinx.android.synthetic.main.favorite_item.view.*

class FavoriteAdapter (private val favoriteList: List<FavoriteItem>) : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val binding =
            FavoriteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val currentItem = favoriteList[position]
        if (currentItem != null) {
            holder.bind(currentItem)
        }

        holder.imageView3.setImageResource(R.drawable.cancel_64)

    }

    override fun getItemCount() =favoriteList.size

    inner class FavoriteViewHolder (private val binding: FavoriteItemBinding) : RecyclerView.ViewHolder (binding.root) {

        //val imageView2: Button? = itemView.button_them
        val imageView3: ImageView = itemView.button_xoa_yeu_thich

        fun bind(favorite: FavoriteItem) {
            binding.apply {
                Glide.with(itemView)
                    .load(favorite.imageResource)
                    .into(anhItemYeuThich)
                tenItemYeuThich.text = favorite.textTenSanPham
                khoiLuongItemYeuThich.text = favorite.textKhoiLuong
                giaItemYeuThich.text = favorite.textGiaSanPham
                giaKhuyenMaiYeuThich.text = favorite.textGiaKhuyenMai
            }
        }

    }
}


