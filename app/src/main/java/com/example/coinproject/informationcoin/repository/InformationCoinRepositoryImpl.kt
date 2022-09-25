package com.example.coinproject.informationcoin.repository

import com.example.coinproject.informationcoin.model.InformationCoinData

class InformationCoinRepositoryImpl : InformationCoinRepository {

    override fun getInformationCoin(): InformationCoinData = test

}

private val test =
    InformationCoinData(
        "Bitcoin",
        "Bitcoin is a decentralized cryptocurrency originally described in a 2008 whitepaper by a person, or group of people, using the alias Satoshi Nakamoto.   It was launched soon after, in January 2009.",
        "btc"
    )

