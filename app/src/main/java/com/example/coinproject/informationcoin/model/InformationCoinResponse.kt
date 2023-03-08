package com.example.coinproject.informationcoin.model

data class InformationCoinResponse(
    val id: String,
    val name: String,
    val image: ImageResponse,
    val description: CoinDescriptionResponse,
    val categories: List<String>
)

data class CoinDescriptionResponse(
    val en: String
)

data class ImageResponse(
    val thumb: String,
    val small: String,
    val large: String
)