package com.example.coinproject.informationcoin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.coinproject.common.fragment.getViewModelFactory
import com.example.coinproject.databinding.FragmentInformationCoinBinding
import com.example.coinproject.informationcoin.model.InformationCoinData
import com.example.coinproject.informationcoin.viewmodel.InformationCoinViewModel

const val coinIdKey = "coinIdKey"

class FragmentInformationCoin : Fragment() {

    private var _binding: FragmentInformationCoinBinding? = null
    private val binding get() = _binding!!

    private val viewModel: InformationCoinViewModel by viewModels { getViewModelFactory() }

    private val coinId by lazy {
        arguments?.getString(coinIdKey)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentInformationCoinBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservables()
        setupListeners()
        viewModel.loadInformation(coinId)
    }

    private fun setupObservables() {
        viewModel.resultInformationCoin.observe(viewLifecycleOwner, ::onDataLoaded)
    }

    private fun onDataLoaded(data: InformationCoinData) {
        binding.apply {
            textInformationCoin.text = data.name

            Glide
                .with(root)
                .load(data.image)
                .into(binding.imageInformationCoin)

            textDescriptionInformationCoin.text = data.description
            textCategoriesInformationCoin.text = data.categories
        }
    }

    private fun setupListeners() {
        binding.imageBackInformationCoin.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    companion object {
        fun create(id: String): FragmentInformationCoin {
            val fragment = FragmentInformationCoin()
            fragment.arguments = bundleOf(coinIdKey to id)
            return fragment
        }
    }
}