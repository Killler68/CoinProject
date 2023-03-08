package com.example.coinproject.informationcoin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinproject.common.flow.createSharedFlow
import com.example.coinproject.informationcoin.model.InformationCoinData
import com.example.coinproject.informationcoin.usecase.InformationCoinUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class InformationCoinViewModel(
    private val getInformationCoin: InformationCoinUseCase,
    private val navigateToListCoin: BackNavigatorUseCase
) : ViewModel() {

    private var _informationCoin: MutableSharedFlow<InformationCoinData> = createSharedFlow()
    val informationCoin: SharedFlow<InformationCoinData> get() = _informationCoin.asSharedFlow()

    fun loadInformation(id: String?) {
        viewModelScope.launch {
            try {
                _informationCoin.tryEmit(getInformationCoin(id))
            } catch (e: Exception) {
                e.message
            }
        }
    }

    fun toBack() = navigateToListCoin()
}