package com.example.coinproject.listcoin.usecase

import com.example.coinproject.listcoin.model.CoinData
import io.reactivex.Single

interface ListCoinUseCase {

    operator fun invoke(): Single<List<CoinData>>

}