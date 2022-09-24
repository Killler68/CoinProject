package com.example.coinproject.listcoin.usecase

import com.example.coinproject.listcoin.model.CoinData
import com.example.coinproject.listcoin.repository.ListCoinRepository

class ListCoinUseCaseImpl(
    private val repository: ListCoinRepository
    ) : ListCoinUseCase {

    override fun invoke(): List<CoinData> {
        return repository.getCoin()
    }
}