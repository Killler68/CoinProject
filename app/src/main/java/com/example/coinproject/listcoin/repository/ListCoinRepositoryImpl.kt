package com.example.coinproject.listcoin.repository

import com.example.coinproject.listcoin.model.CoinData

class ListCoinRepositoryImpl() : ListCoinRepository {

    override fun getCoin(): List<CoinData> = test

}

private val test = listOf(
    CoinData("1", "Bitcoin", "BTC", 20000, 2),
    CoinData("1", "Ethereum", "ETH", 3000, 3),
    CoinData("1", "Binance", "BNB", 80, 0),
    CoinData("1", "Bitcoin", "BTC", 20000, 2),
    CoinData("1", "Bitcoin", "BTC", 20000, 2),
    CoinData("1", "Bitcoin", "BTC", 20000, 2),
    CoinData("1", "Bitcoin", "BTC", 20000, 2),
    CoinData("1", "Bitcoin", "BTC", 20000, 2),
    CoinData("1", "Bitcoin", "BTC", 20000, 2),
    CoinData("1", "Bitcoin", "BTC", 20000, 2),
    CoinData("1", "Bitcoin", "BTC", 20000, 2),
    CoinData("1", "Bitcoin", "BTC", 20000, 2),
    CoinData("1", "Bitcoin", "BTC", 20000, 2),
    CoinData("1", "Bitcoin", "BTC", 20000, 2),
    CoinData("1", "Bitcoin", "BTC", 20000, 2),
    )