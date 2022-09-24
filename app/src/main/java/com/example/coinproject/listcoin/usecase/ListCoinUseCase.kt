package com.example.coinproject.listcoin.usecase

import com.example.coinproject.listcoin.model.CoinData

interface ListCoinUseCase {

    operator fun invoke(): List<CoinData>

}