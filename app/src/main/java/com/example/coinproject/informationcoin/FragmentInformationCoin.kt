package com.example.coinproject.informationcoin

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentInformationCoinBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arguments = requireArguments().getString(coinIdKey)


        setupObservables()
        setupListeners()
        if (arguments != null) {
            viewModel.loadInformation(arguments)
        }
        shareCoin()
    }

    private fun setupObservables() {
        viewModel.resultInformationCoin.observe(viewLifecycleOwner, ::onDataLoaded)
        viewModel.navCommand.observe(viewLifecycleOwner, ::onDataLoadedNavigate)
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

    private fun onDataLoadedNavigate() {
    }

    private fun shareCoin() {
        binding.imageShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            val shareUrl = "https://api.coingecko.com/api/v3/coins/${coinIdKey}"
            intent.putExtra(Intent.EXTRA_TEXT, shareUrl)
            startActivity(Intent.createChooser(intent, "shape"))
        }
    }

    private fun setupListeners() {
        binding.imageBackInformationCoin.setOnClickListener {

        }
    }
}