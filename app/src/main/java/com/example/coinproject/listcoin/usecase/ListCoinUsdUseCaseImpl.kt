package com.example.coinproject.listcoin.usecase

import com.example.coinproject.listcoin.model.CoinData
import com.example.coinproject.listcoin.repository.ListCoinUsdRepository

class ListCoinUsdUseCaseImpl(private val repositoryUsd: ListCoinUsdRepository) :
    ListCoinUsdUseCase {

    override suspend operator fun invoke(): List<CoinData> = repositoryUsd.getCoinsUsd()
}