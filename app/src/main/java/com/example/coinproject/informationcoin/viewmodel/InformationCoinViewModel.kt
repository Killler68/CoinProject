package com.example.coinproject.informationcoin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coinproject.common.rx.plusAssign
import com.example.coinproject.informationcoin.model.InformationCoinData
import com.example.coinproject.informationcoin.usecase.InformationCoinUseCase
import io.reactivex.disposables.CompositeDisposable

class InformationCoinViewModel(
    private val useCase: InformationCoinUseCase
) : ViewModel() {

    private var _resultInformationCoin: MutableLiveData<InformationCoinData> = MutableLiveData()
    val resultInformationCoin: LiveData<InformationCoinData> get() = _resultInformationCoin

    private val _internetError: MutableLiveData<String> = MutableLiveData()
    val internetError: LiveData<String> get() = _internetError

    private var compositeDisposable = CompositeDisposable()

    fun loadInformation(id: String) {
        compositeDisposable += useCase()
            .subscribe({
                _resultInformationCoin.postValue(it)
            }, {
                _internetError.postValue(it.message)
            })
    }
}