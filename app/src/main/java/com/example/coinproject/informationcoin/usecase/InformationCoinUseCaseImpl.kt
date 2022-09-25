package com.example.coinproject.informationcoin.usecase

import com.example.coinproject.informationcoin.model.InformationCoinData
import com.example.coinproject.informationcoin.repository.InformationCoinRepository

class InformationCoinUseCaseImpl(
    private val repository: InformationCoinRepository
) : InformationCoinUseCase {

    override fun invoke(): InformationCoinData {
        return repository.getInformationCoin()
    }
}