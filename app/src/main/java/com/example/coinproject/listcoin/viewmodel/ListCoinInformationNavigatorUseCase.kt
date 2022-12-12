package com.example.coinproject.listcoin.viewmodel

import com.example.coinproject.common.navigation.NavCommand

interface ListCoinInformationNavigatorUseCase {

    operator fun invoke(id: String): NavCommand
}