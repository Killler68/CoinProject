package com.example.coinproject.informationcoin.usecase

import com.example.coinproject.informationcoin.model.InformationCoinData
import com.example.coinproject.informationcoin.repository.InformationCoinRepository
import io.reactivex.Single

class InformationCoinUseCaseImpl(
    private val repositoryInformationCoin: InformationCoinRepository
) : InformationCoinUseCase {

    override fun invoke(id: String?): Single<InformationCoinData> {
        return repositoryInformationCoin.getInformationCoin(id)
    }
}
