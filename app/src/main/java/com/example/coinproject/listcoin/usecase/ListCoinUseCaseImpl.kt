package com.example.coinproject.listcoin.usecase

import com.example.coinproject.listcoin.model.CoinData
import com.example.coinproject.listcoin.repository.ListCoinRepository
import io.reactivex.Single

class ListCoinUseCaseImpl(private val repository: ListCoinRepository) : ListCoinUseCase {

    override operator fun invoke(): Single<List<CoinData>> {
        return repository.getCoinsUsd()
    }

    override fun invokes(): Single<List<CoinData>> {
        return repository.getCoinsEur()
    }
}