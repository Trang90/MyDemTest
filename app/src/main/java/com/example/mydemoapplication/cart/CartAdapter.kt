package com.example.mydemoapplication.cart

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mydemoapplication.databinding.CartItemBinding

class CartAdapter (private val cartList: List<CartItem>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>(){
//class CartAdapter: ListAdapter<CartItem, CartAdapter.CartViewHolder>(CartDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding =
            CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)

    }


    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        //val currentItem = getItem(position)
        val currentItem = cartList[position]
        if (currentItem != null) {
            holder.bind(currentItem)
        }
//        holder.imageView2.setImageResource(R.drawable.minus)
//        holder.imageView3.setImageResource(R.drawable.add)

    }

    override fun getItemCount() = cartList.size

    inner class CartViewHolder(private val binding: CartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cart: CartItem) {
            binding.apply {
                Glide.with(itemView)
                    .load(cart.imageResource)
                    .into(anhItemGioHang)
                tenItemGioHang.text = cart.textTenSanPham
                khoiLuongItemGioHang.text = cart.textKhoiLuong
                giaItemGioHang.text = cart.textGiaSanPham
                giakhuyenmai.text = cart.textGiaKhuyenMai
            }
        }

//        val imageView2: ImageView = itemView.button_giam
//        val imageView3: ImageView = itemView.button_tang

    }

    class CartDiffCallback : DiffUtil.ItemCallback<CartItem>() {
        override fun areItemsTheSame(oldItem: CartItem, newItem: CartItem) =
            oldItem.textTenSanPham == newItem.textTenSanPham

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: CartItem, newItem: CartItem) =
            oldItem == newItem
    }


}