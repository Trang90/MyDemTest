package com.example.mydemoapplication.favorite

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mydemoapplication.R
import com.example.mydemoapplication.TopSpacingItemDecoration
import com.example.mydemoapplication.catalog.CatalogAdapter
import com.example.mydemoapplication.catalog.CatalogItem
import com.example.mydemoapplication.databinding.CartFragmentBinding
import com.example.mydemoapplication.databinding.FavoriteFragmentBinding
import kotlinx.android.synthetic.main.favorite_fragment.*

class FavoriteFragment : Fragment(R.layout.favorite_fragment) {
    private lateinit var binding: FavoriteFragmentBinding
    private val favoriteList = generateDummyList(500)

    companion object {
        fun newInstance() = FavoriteFragment()
    }

    private fun generateDummyList(size: Int): List<FavoriteItem> {

        val list = ArrayList<FavoriteItem>()
        for (i in 0 until size) {
            val drawable = when (i % 6) {
                0 -> R.drawable.bungao
                1 -> R.drawable.donglanh
                2 -> R.drawable.nuoccham
                3 -> R.drawable.raucu
                4 -> R.drawable.dokho
                else -> R.drawable.dohop
            }

            val item = FavoriteItem(drawable, "Item $i", "€ $i", "giá:", "$i kg")
            list += item
        }
        return list}

    private lateinit var viewModel: FavoriteViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding= FavoriteFragmentBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FavoriteViewModel::class.java)
        // TODO: Use the ViewModel

        binding.recyclerViewYeuThich.apply {
            adapter = FavoriteAdapter(favoriteList)
            layoutManager = GridLayoutManager(activity, 1)
            setHasFixedSize(true)
            val topSpacingDecorator = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingDecorator)
        }
    }

}