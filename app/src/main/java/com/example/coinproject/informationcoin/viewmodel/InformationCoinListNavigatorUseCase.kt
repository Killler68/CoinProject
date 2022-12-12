package com.example.coinproject.informationcoin.viewmodel

import com.example.coinproject.common.navigation.NavCommand

interface InformationCoinListNavigatorUseCase {

    operator fun invoke(): NavCommand
}