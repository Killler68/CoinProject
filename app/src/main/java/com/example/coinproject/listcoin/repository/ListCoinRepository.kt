package com.example.coinproject.listcoin.repository

import com.example.coinproject.listcoin.model.CoinData

interface ListCoinRepository {

    fun getCoin(): List<CoinData>

}