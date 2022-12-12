package com.example.coinproject.informationcoin.usecase

import com.example.coinproject.common.navigation.NavCommand
import com.example.coinproject.informationcoin.viewmodel.InformationCoinListNavigatorUseCase

class InformationCoinListNavigatorUseCaseImpl(private val router: InformationCoinRouter) :
    InformationCoinListNavigatorUseCase {

    override fun invoke(): NavCommand = router.toListCoin()
}