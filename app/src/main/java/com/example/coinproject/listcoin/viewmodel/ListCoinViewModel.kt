package com.example.coinproject.listcoin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coinproject.common.rx.plusAssign
import com.example.coinproject.listcoin.model.CoinData
import com.example.coinproject.listcoin.usecase.ListCoinUseCase
import io.reactivex.disposables.CompositeDisposable

class ListCoinViewModel(
    private val getCoins: ListCoinUseCase,
) : ViewModel() {

    private var _resultData: MutableLiveData<List<CoinData>> = MutableLiveData()
    val resultData: LiveData<List<CoinData>> get() = _resultData

    private val _internetError: MutableLiveData<String> = MutableLiveData()
    val internetError: LiveData<String> get() = _internetError

    private var compositeDisposable = CompositeDisposable()

    fun loadCoin() {
        compositeDisposable += getCoins()
            .subscribe({
                _resultData.postValue(it)
            }, {
                _internetError.postValue(it.message)
            })
    }

    fun loadCoins() {
        compositeDisposable += getCoins.invokes()
            .subscribe({
                _resultData.postValue(it)
            }, {
                _internetError.postValue(it.message)
            })
    }
}