package com.example.coinproject.informationcoin.usecase

import com.example.coinproject.informationcoin.model.InformationCoinData
import com.example.coinproject.informationcoin.repository.InformationCoinRepository

class InformationCoinUseCaseImpl(
    private val repositoryInformationCoin: InformationCoinRepository
) : InformationCoinUseCase {

    override suspend fun invoke(id: String?): InformationCoinData {
        return repositoryInformationCoin.getInformationCoin(id)
    }
}
