package com.example.coinproject.listcoin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.coinproject.common.fragment.getViewModelFactory
import com.example.coinproject.common.fragment.navigateToFragment
import com.example.coinproject.databinding.FragmentListCoinBinding
import com.example.coinproject.informationcoin.FragmentInformationCoin
import com.example.coinproject.listcoin.item.ListCoinItem
import com.example.coinproject.listcoin.model.CoinData
import com.example.coinproject.listcoin.model.State
import com.example.coinproject.listcoin.viewmodel.ListCoinViewModel
import com.mikepenz.fastadapter.GenericFastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.diff.FastAdapterDiffUtil

class FragmentListCoin : Fragment() {

    private var _binding: FragmentListCoinBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ListCoinViewModel by viewModels { getViewModelFactory() }

    private val listCoinItemAdapter = ItemAdapter<ListCoinItem>()
    private val fastAdapter = GenericFastAdapter.with(listOf(listCoinItemAdapter))


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentListCoinBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.recyclerCoin) {
            adapter = fastAdapter
            itemAnimator = null
        }
        setupObservables()
        setupListeners()
        viewModel.loadCoinsUsd()
    }

    private fun setupObservables() {
        viewModel.resultListCoins.observe(viewLifecycleOwner, ::onDataLoaded)
        viewModel.screenState.observe(viewLifecycleOwner, ::stateScreen)
    }

    private fun onDataLoaded(coinData: List<CoinData>) {
        FastAdapterDiffUtil[listCoinItemAdapter] = coinData.map {
            ListCoinItem(
                it,
                ::onClick
            )
        }
    }

    private fun setupListeners() {
        with(binding) {
            btnUsd.setOnClickListener {
                viewModel.loadCoinsUsd()
            }
            btnEur.setOnClickListener {
                viewModel.loadCoinsEur()
            }
            includedError.btnErrorRefresh.setOnClickListener {
                viewModel.loadCoinsUsd()
            }
        }
    }

    private fun stateScreen(state: State) =
        when (state) {
            is State.Loading -> onScreenLoading()
            is State.Loaded -> onScreenLoaded()
            is State.Error -> onError()
        }

    private fun onScreenLoading() {
        binding.cardView.isVisible = false
        binding.includedError.groupError.isVisible = false
        binding.includedError.progressBar.isVisible = true
    }

    private fun onScreenLoaded() {
        binding.cardView.isVisible = true
        binding.includedError.groupError.isVisible = false
        binding.includedError.progressBar.isVisible = false
    }

    private fun onError() {
        binding.cardView.isVisible = false
        binding.includedError.progressBar.isVisible = false
        binding.includedError.groupError.isVisible = true
    }

    private fun onClick(coinId: String) {
        val fragmentPhoto = FragmentInformationCoin.create(coinId)
        navigateToFragment(fragmentPhoto)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}