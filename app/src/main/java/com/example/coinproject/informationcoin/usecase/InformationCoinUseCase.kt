package com.example.coinproject.informationcoin.usecase

import com.example.coinproject.informationcoin.model.InformationCoinData

interface InformationCoinUseCase {

    operator fun invoke(): InformationCoinData

}