package com.example.mydemoapplication.catalog

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
//import com.example.mydemoapplication.CatalogFragmentArgs
import com.example.mydemoapplication.R
import com.example.mydemoapplication.TopSpacingItemDecoration
import com.example.mydemoapplication.cart.CartAdapter
import com.example.mydemoapplication.databinding.CartFragmentBinding
import com.example.mydemoapplication.databinding.CatalogFragmentBinding
import kotlinx.android.synthetic.main.catalog_fragment.*

class CatalogFragment : Fragment(R.layout.catalog_fragment), CatalogAdapter.OnItemClickListener {
    private lateinit var binding: CatalogFragmentBinding
    private val catalogList = generateDummyList(500)

    companion object {
        fun newInstance() = CatalogFragment()
    }

    private lateinit var viewModel: CatalogViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding= CatalogFragmentBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)

        val args = CatalogFragmentArgs.fromBundle(arguments!!)
        Toast.makeText(context, "Catalog ID: ${args.catalogID}", Toast.LENGTH_SHORT).show()


    }

    private fun generateDummyList(size: Int): List<CatalogItem> {

        val list = ArrayList<CatalogItem>()
        for (i in 0 until size) {
            val drawable = when (i % 6) {
                0 -> R.drawable.bungao
                1 -> R.drawable.donglanh
                2 -> R.drawable.nuoccham
                3 -> R.drawable.raucu
                4 -> R.drawable.dokho
                else -> R.drawable.dohop
            }

            val item = CatalogItem(drawable, "Item $i", "€ $i", "giá:")
            list += item
        }
        return list}

    override fun onItemClick(position: Int) {
        val detailID = position
        //Toast.makeText(activity, "Item $position clicked", Toast.LENGTH_SHORT).show()
        view?.findNavController()?.navigate(CatalogFragmentDirections.actionCatalogFragmentToDetailItemFragment(detailID))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CatalogViewModel::class.java)
        // TODO: Use the ViewModel

        binding.recyclerViewCatalog.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = CatalogAdapter(catalogList, this@CatalogFragment)
            //adapter = CatalogAdapter()
            setHasFixedSize(true)
            val topSpacingDecorator = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingDecorator)

        }




    }

}