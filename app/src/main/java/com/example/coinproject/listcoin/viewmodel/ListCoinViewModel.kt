package com.example.coinproject.listcoin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinproject.listcoin.model.CoinData
import com.example.coinproject.listcoin.usecase.ListCoinUseCase
import kotlinx.coroutines.launch

class ListCoinViewModel(
    private val getCoins: ListCoinUseCase,
) : ViewModel() {

    private var _resultData: MutableLiveData<List<CoinData>> = MutableLiveData()
    val resultData: LiveData<List<CoinData>> get() = _resultData

    fun loadCoin() {
        viewModelScope.launch {
            val data = getCoins()
            _resultData.postValue(data)
        }
    }


}