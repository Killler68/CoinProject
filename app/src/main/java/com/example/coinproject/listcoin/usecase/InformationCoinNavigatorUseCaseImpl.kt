package com.example.coinproject.listcoin.usecase

import com.example.coinproject.common.navigation.Screens
import com.example.coinproject.listcoin.viewmodel.InformationCoinNavigatorUseCase
import com.github.terrakok.cicerone.Router

class InformationCoinNavigatorUseCaseImpl(
    private val router: Router
) : InformationCoinNavigatorUseCase {

    override fun invoke(id: String) = router.navigateTo(Screens.toInformationCoin(id))
}