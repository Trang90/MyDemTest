package com.example.mydemoapplication.Main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager

import com.example.mydemoapplication.R
import com.example.mydemoapplication.TopSpacingItemDecoration
import com.example.mydemoapplication.databinding.CatalogFragmentBinding
import com.example.mydemoapplication.databinding.MainFragmentBinding
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment(R.layout.main_fragment), MainAdapter.OnItemClickListener {
    private lateinit var binding: MainFragmentBinding
    private val exampleList = generateDummyList(6)

//    companion object {
//        fun newInstance() = MainFragment()
//    }

    private lateinit var viewModel: MainViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding= MainFragmentBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onItemClick(position: Int) {
        val catalogID = position
        //Toast.makeText(activity, "Catalog $position clicked", Toast.LENGTH_SHORT).show()
        view?.findNavController()?.navigate(
            MainFragmentDirections.actionMainFragmentToCatalogFragment(
                catalogID
            )
        )
    }

    private fun generateDummyList(size: Int): List<ExampleItem> {
        val list = ArrayList<ExampleItem>()
        for (i in 0 until size) {
            val drawable = when (i % 6) {
                0 -> R.drawable.bungao
                1 -> R.drawable.donglanh
                2 -> R.drawable.nuoccham
                3 -> R.drawable.raucu
                4 -> R.drawable.dokho
                else -> R.drawable.dohop
            }
            val item = ExampleItem(drawable, "Item $i")
            list += item
        }
        return list}

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        binding.recyclerViewMain.apply{
            adapter = MainAdapter(exampleList, this@MainFragment)
            layoutManager = GridLayoutManager(activity, 2)
            setHasFixedSize(true)
            val topSpacingDecorator = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingDecorator)
        }

    }





}