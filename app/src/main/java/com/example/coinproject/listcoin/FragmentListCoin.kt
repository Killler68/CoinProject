package com.example.coinproject.listcoin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.coinproject.common.flow.launchWhenViewCreated
import com.example.coinproject.common.fragment.getViewModelFactory
import com.example.coinproject.databinding.FragmentListCoinBinding
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
        launchWhenViewCreated {
            viewModel.listCoins.observe(::onDataLoaded)
            viewModel.screenState.observe(viewLifecycleOwner, ::stateScreen)
        }
    }

    private fun onDataLoaded(coinData: List<CoinData>) {
        FastAdapterDiffUtil[listCoinItemAdapter] = coinData.map {
            ListCoinItem(
                it,
                viewModel::toInformationCoin
            )
        }
    }

    private fun setupListeners() {
        with(binding) {
            btnUsd.setOnClickListener {
                viewModel.loadCoinsUsd(false)
            }
            btnEur.setOnClickListener {
                viewModel.loadCoinsEur(false)
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
        binding.group.isVisible = false
        binding.includedError.groupError.isVisible = false
        binding.includedError.progressBar.isVisible = true
        binding.includedError.root.isVisible = true
    }

    private fun onScreenLoaded() {
        binding.group.isVisible = true
        binding.includedError.groupError.isVisible = false
        binding.includedError.progressBar.isVisible = false
        binding.includedError.root.isVisible = false

    }

    private fun onError() {
        binding.group.isVisible = false
        binding.includedError.progressBar.isVisible = false
        binding.includedError.groupError.isVisible = true
        binding.includedError.root.isVisible = true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}