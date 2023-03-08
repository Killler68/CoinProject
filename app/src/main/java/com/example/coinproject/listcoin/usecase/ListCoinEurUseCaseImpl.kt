package com.example.coinproject.listcoin.usecase

import com.example.coinproject.listcoin.model.CoinData
import com.example.coinproject.listcoin.repository.ListCoinEurRepository
import io.reactivex.Single

class ListCoinEurUseCaseImpl(private val repositoryEur: ListCoinEurRepository) :
    ListCoinEurUseCase {

    override suspend fun invoke(): List<CoinData> = repositoryEur.getCoinsEur()

}