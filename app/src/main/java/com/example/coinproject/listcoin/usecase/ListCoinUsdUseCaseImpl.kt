package com.example.coinproject.listcoin.usecase

import com.example.coinproject.listcoin.model.CoinData
import com.example.coinproject.listcoin.repository.ListCoinUsdRepository
import io.reactivex.Single

class ListCoinUsdUseCaseImpl(private val repositoryUsd: ListCoinUsdRepository) :
    ListCoinUsdUseCase {

    override operator fun invoke(): Single<List<CoinData>> {
        return repositoryUsd.getCoinsUsd()
    }
}