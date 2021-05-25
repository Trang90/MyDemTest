package com.example.mydemoapplication.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mydemoapplication.R
import com.example.mydemoapplication.catalog.CatalogFragmentArgs
import com.example.mydemoapplication.databinding.DetailItemFragmentBinding

class DetailItemFragment : Fragment(R.layout.detail_item_fragment) {
    private lateinit var binding: DetailItemFragmentBinding

    companion object {
        fun newInstance() = DetailItemFragment()
    }

    private lateinit var viewModel: DetailItemViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding=DetailItemFragmentBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)

        val args = DetailItemFragmentArgs.fromBundle(arguments!!)
        Toast.makeText(context, "ID Sản Phẩm: ${args.detailID}", Toast.LENGTH_SHORT).show()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailItemViewModel::class.java)
        // TODO: Use the ViewModel
    }

}