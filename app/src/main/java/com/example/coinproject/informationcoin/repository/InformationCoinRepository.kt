package com.example.coinproject.informationcoin.repository

import com.example.coinproject.informationcoin.model.InformationCoinData

interface InformationCoinRepository {

    fun getInformationCoin(): InformationCoinData
}