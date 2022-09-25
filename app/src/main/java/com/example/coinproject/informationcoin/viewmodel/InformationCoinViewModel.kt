package com.example.coinproject.informationcoin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinproject.informationcoin.model.InformationCoinData
import com.example.coinproject.informationcoin.usecase.InformationCoinUseCase
import kotlinx.coroutines.launch

class InformationCoinViewModel(
    private val useCase: InformationCoinUseCase
) : ViewModel() {

    private var _resultInformationCoin: MutableLiveData<InformationCoinData> = MutableLiveData()
    val resultInformationCoin: LiveData<InformationCoinData> get() = _resultInformationCoin

    fun loadInformation() {
        viewModelScope.launch {
            _resultInformationCoin.postValue(useCase())
        }
    }
}