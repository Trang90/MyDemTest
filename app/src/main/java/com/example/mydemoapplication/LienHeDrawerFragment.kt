package com.example.mydemoapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mydemoapplication.databinding.FragmentLienHeDrawerBinding
import com.example.mydemoapplication.databinding.FragmentVanChuyenDrawerBinding


class LienHeDrawerFragment : Fragment(R.layout.fragment_lien_he_drawer) {
    private lateinit var binding: FragmentLienHeDrawerBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding= FragmentLienHeDrawerBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
        binding.tvLienHe.setText(R.string.thong_tin_thanh_toan_body)
    }
}