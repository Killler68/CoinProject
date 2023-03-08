package com.example.coinproject.listcoin.usecase

import com.example.coinproject.listcoin.model.CoinData

interface ListCoinUsdUseCase {

    suspend operator fun invoke(): List<CoinData>
}