package com.example.mydemoapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mydemoapplication.databinding.DetailItemFragmentBinding
import com.example.mydemoapplication.databinding.FragmentThanhToanDrawerBinding
import com.example.mydemoapplication.detail.DetailItemFragmentArgs
import com.example.mydemoapplication.search.SearchViewModel

class ThanhToanDrawerFragment : Fragment(R.layout.fragment_thanh_toan_drawer) {

    private lateinit var binding: FragmentThanhToanDrawerBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding= FragmentThanhToanDrawerBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
        binding.tvThanhToan.setText(R.string.thong_tin_thanh_toan_body)
        binding.tvClickAndCollect.setText(R.string.thong_tin_thanh_toan_body_cac)
    }



}