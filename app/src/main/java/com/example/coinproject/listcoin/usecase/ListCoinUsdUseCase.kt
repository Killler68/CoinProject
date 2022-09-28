package com.example.coinproject.listcoin.usecase

import com.example.coinproject.listcoin.model.CoinData
import io.reactivex.Single

interface ListCoinUsdUseCase {

    operator fun invoke(): Single<List<CoinData>>

}