package com.example.coinproject.informationcoin.usecase

import com.example.coinproject.informationcoin.model.InformationCoinData

interface InformationCoinUseCase {

    suspend operator fun invoke(id: String?): InformationCoinData
}