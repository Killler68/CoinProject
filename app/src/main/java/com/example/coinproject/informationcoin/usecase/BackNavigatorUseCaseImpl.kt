package com.example.coinproject.informationcoin.usecase

import com.example.coinproject.informationcoin.viewmodel.BackNavigatorUseCase
import com.github.terrakok.cicerone.Router

class BackNavigatorUseCaseImpl(
    private val router: Router
) : BackNavigatorUseCase {

    override fun invoke() = router.exit()
}