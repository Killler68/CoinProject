package com.example.coinproject.listcoin.usecase

import com.example.coinproject.common.navigation.NavCommand

interface ListCoinRouter {

    fun toInformationCoin(id: String): NavCommand
}