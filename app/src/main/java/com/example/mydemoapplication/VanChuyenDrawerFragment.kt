package com.example.mydemoapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mydemoapplication.databinding.FragmentThanhToanDrawerBinding
import com.example.mydemoapplication.databinding.FragmentVanChuyenDrawerBinding


class VanChuyenDrawerFragment : Fragment(R.layout.fragment_van_chuyen_drawer) {

    private lateinit var binding: FragmentVanChuyenDrawerBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding= FragmentVanChuyenDrawerBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
        binding.tvGiaoHangFirst.setText(R.string.thong_tin_giao_hang_body_duoi_50)
        binding.tvGiaoHangSecond.setText(R.string.thong_tin_giao_hang_body_tren_50)
        binding.tvGiaoHangThird.setText(R.string.thong_tin_giao_hang_body_lien_he)
    }

}