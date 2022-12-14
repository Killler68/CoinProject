package com.example.coinproject.listcoin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coinproject.common.navigation.NavCommand
import com.example.coinproject.common.rx.plusAssign
import com.example.coinproject.listcoin.model.CoinData
import com.example.coinproject.listcoin.model.State
import com.example.coinproject.listcoin.usecase.ListCoinEurUseCase
import com.example.coinproject.listcoin.usecase.ListCoinUsdUseCase
import io.reactivex.disposables.CompositeDisposable

class ListCoinViewModel(
    private val getCoinsUsd: ListCoinUsdUseCase,
    private val getCoinsEur: ListCoinEurUseCase,
    private val navigatorToInformation: ListCoinInformationNavigatorUseCase
) : ViewModel() {

    private var _resultListCoins: MutableLiveData<List<CoinData>> = MutableLiveData()
    val resultListCoins: LiveData<List<CoinData>> get() = _resultListCoins

    private var _screenState: MutableLiveData<State> = MutableLiveData()
    val screenState: LiveData<State> get() = _screenState

    private val _navCommand: MutableLiveData<NavCommand> = MutableLiveData()
    val navCommand: LiveData<NavCommand> get() = _navCommand

    private var compositeDisposable = CompositeDisposable()

    fun loadCoinsUsd(showProgress: Boolean = true) {
        if (showProgress) _screenState.postValue(State.Loading)
        compositeDisposable += getCoinsUsd()
            .subscribe({
                _resultListCoins.postValue(it)
                _screenState.postValue(State.Loaded)
            }, {
                _screenState.postValue(State.Error)
            })
    }

    fun loadCoinsEur(showProgress: Boolean = true) {
        if (showProgress) _screenState.postValue(State.Loading)
        compositeDisposable += getCoinsEur.invoke()
            .subscribe({
                _resultListCoins.postValue(it)
                _screenState.postValue(State.Loaded)
            }, {
                _screenState.postValue(State.Error)
            })
    }

    fun navigateToInformation(id: String) {
        _navCommand.postValue(navigatorToInformation(id))
    }
}