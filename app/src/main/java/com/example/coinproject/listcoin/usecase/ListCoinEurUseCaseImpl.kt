package com.example.coinproject.listcoin.usecase

import com.example.coinproject.listcoin.model.CoinData
import com.example.coinproject.listcoin.repository.ListCoinEurRepository
import io.reactivex.Single

class ListCoinEurUseCaseImpl(private val repositoryEur: ListCoinEurRepository) :
    ListCoinEurUseCase {

    override fun invoke(): Single<List<CoinData>> {
        return repositoryEur.getCoinsEur()
    }
}