package com.example.coinproject.listcoin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coinproject.common.rx.plusAssign
import com.example.coinproject.listcoin.model.CoinData
import com.example.coinproject.listcoin.usecase.ListCoinEurUseCase
import com.example.coinproject.listcoin.usecase.ListCoinUsdUseCase
import io.reactivex.disposables.CompositeDisposable

class ListCoinViewModel(
    private val getCoinsUsd: ListCoinUsdUseCase,
    private val getCoinsEur: ListCoinEurUseCase
) : ViewModel() {

    private var _resultListCoins: MutableLiveData<List<CoinData>> = MutableLiveData()
    val resultListCoins: LiveData<List<CoinData>> get() = _resultListCoins

    private val _internetError: MutableLiveData<String> = MutableLiveData()
    val internetError: LiveData<String> get() = _internetError

    private var compositeDisposable = CompositeDisposable()

    fun loadCoinsUsd() {
        compositeDisposable += getCoinsUsd()
            .subscribe({
                _resultListCoins.postValue(it)
            }, {
                _internetError.postValue(it.message)
            })
    }

    fun loadCoinsEur() {
        compositeDisposable += getCoinsEur.invoke()
            .subscribe({
                _resultListCoins.postValue(it)
            }, {
                _internetError.postValue(it.message)
            })
    }
}