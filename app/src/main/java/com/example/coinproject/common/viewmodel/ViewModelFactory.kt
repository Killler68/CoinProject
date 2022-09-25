package com.example.coinproject.common.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coinproject.listcoin.repository.ListCoinRepositoryImpl
import com.example.coinproject.listcoin.usecase.ListCoinUseCaseImpl
import com.example.coinproject.listcoin.viewmodel.ListCoinViewModel

//class ViewModelFactory() : ViewModelProvider.Factory {
//
//    private val repository = ListCoinRepositoryImpl()
//    private val useCase = ListCoinUseCaseImpl(repository)
//    private val viewModel = ListCoinViewModel(useCase)
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T =
//        viewModel as T
//}