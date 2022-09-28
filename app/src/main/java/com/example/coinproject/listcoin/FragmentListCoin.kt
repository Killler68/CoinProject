package com.example.coinproject.listcoin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.coinproject.common.fragment.getViewModelFactory
import com.example.coinproject.common.fragment.navigateToFragment
import com.example.coinproject.databinding.FragmentListCoinBinding
import com.example.coinproject.informationcoin.FragmentInformationCoin
import com.example.coinproject.listcoin.item.ListCoinItem
import com.example.coinproject.listcoin.model.CoinData
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
        viewModel.loadCoin()
    }

    private fun setupObservables() {
        viewModel.resultData.observe(viewLifecycleOwner, ::onDataLoaded)
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
        binding.btnUsd.setOnClickListener {
            viewModel.loadCoin()
        }
        binding.btnEur.setOnClickListener {
            viewModel.loadCoins()
        }
    }

    private fun onClick(coinId: String) {
        val fragmentPhoto = FragmentInformationCoin.create(coinId)
        navigateToFragment(fragmentPhoto)
    }

}