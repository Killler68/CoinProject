package com.example.coinproject.listcoin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinproject.listcoin.model.CoinData
import com.example.coinproject.listcoin.model.State
import com.example.coinproject.listcoin.usecase.ListCoinEurUseCase
import com.example.coinproject.listcoin.usecase.ListCoinUsdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ListCoinViewModel(
    private val getCoinsUsd: ListCoinUsdUseCase,
    private val getCoinsEur: ListCoinEurUseCase,
    private val navigateToInformationCoin: InformationCoinNavigatorUseCase
) : ViewModel() {

    private var _listCoins: MutableStateFlow<List<CoinData>> = MutableStateFlow(emptyList())
    val listCoins: StateFlow<List<CoinData>> get() = _listCoins.asStateFlow()

    private var _screenState: MutableLiveData<State> = MutableLiveData()
    val screenState: LiveData<State> get() = _screenState

    fun loadCoinsUsd(showProgress: Boolean = true) {
        viewModelScope.launch {
            if (showProgress) _screenState.postValue(State.Loading)
            try {
                _listCoins.tryEmit(getCoinsUsd())
                _screenState.postValue(State.Loaded)
            } catch (e: Exception) {
                _screenState.postValue(State.Error)
            }
        }
    }

    fun loadCoinsEur(showProgress: Boolean = true) {
        viewModelScope.launch {
            if (showProgress) _screenState.postValue(State.Loading)
            try {
                _listCoins.tryEmit(getCoinsEur())
                _screenState.postValue(State.Loaded)
            } catch (e: Exception) {
                _screenState.postValue(State.Error)
            }
        }
    }

    fun toInformationCoin(id: String) = navigateToInformationCoin(id)
}