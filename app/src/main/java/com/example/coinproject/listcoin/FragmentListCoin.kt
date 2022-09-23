package com.example.coinproject.listcoin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.coinproject.databinding.FragmentListCoinBinding

class FragmentListCoin : Fragment() {

    private var _binding: FragmentListCoinBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentListCoinBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

}