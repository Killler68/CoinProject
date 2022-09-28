package com.example.coinproject.informationcoin.usecase

import com.example.coinproject.informationcoin.model.InformationCoinData
import io.reactivex.Single

interface InformationCoinUseCase {

    operator fun invoke(id:String): Single<InformationCoinData>

}