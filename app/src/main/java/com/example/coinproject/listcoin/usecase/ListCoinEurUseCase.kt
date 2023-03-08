package com.example.coinproject.listcoin.usecase

import com.example.coinproject.listcoin.model.CoinData

interface ListCoinEurUseCase {

    suspend operator fun invoke(): List<CoinData>
}