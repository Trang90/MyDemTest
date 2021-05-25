package com.example.mydemoapplication.cart

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mydemoapplication.R
import com.example.mydemoapplication.TopSpacingItemDecoration
import com.example.mydemoapplication.databinding.CartFragmentBinding

class CartFragment : Fragment(R.layout.cart_fragment) {
    private lateinit var binding: CartFragmentBinding
    private val cartList = generateDummyList(500)

    companion object {
        fun newInstance() = CartFragment()
    }

    private lateinit var viewModel: CartViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding=CartFragmentBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
    }

    private fun generateDummyList(size: Int): List<CartItem> {

        val list = ArrayList<CartItem>()
        for (i in 0 until size) {
            val drawable = when (i % 6) {
                0 -> R.drawable.bungao
                1 -> R.drawable.donglanh
                2 -> R.drawable.nuoccham
                3 -> R.drawable.raucu
                4 -> R.drawable.dokho
                else -> R.drawable.dohop
            }

            val item = CartItem(drawable, "Item $i", "$i kg", "€ $i", "€ $i", "Số lượng: ")
            list += item
        }
        return list
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CartViewModel::class.java)
        // TODO: Use the ViewModel


        binding.recyclerViewGioHang.apply {
            layoutManager = GridLayoutManager(activity, 1)
            adapter = CartAdapter(cartList)
            //adapter = CartAdapter()
            setHasFixedSize(true)
            val topSpacingDecorator = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingDecorator)

        }
    }

}