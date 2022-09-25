package com.example.coinproject.informationcoin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.coinproject.common.fragment.getViewModelFactory
import com.example.coinproject.common.fragment.navigateToFragment
import com.example.coinproject.databinding.FragmentInformationCoinBinding
import com.example.coinproject.informationcoin.viewmodel.InformationCoinViewModel
import com.example.coinproject.listcoin.FragmentListCoin

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

        viewModel.resultInformationCoin.observe(viewLifecycleOwner) {
            binding.apply {
                textInformationCoin.text = it.coinName
                textDescriptionInformationCoin.text = it.coinDescription
                textCategoriesInformationCoin.text = it.coinCategory
            }
        }
        viewModel.loadInformation()

        binding.imageBackInformationCoin.setOnClickListener {
            navigateToFragment(FragmentListCoin())
        }
    }

}