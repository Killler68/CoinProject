package com.example.coinproject.informationcoin.model

data class CoinDetailResponse(
    val id: String,
    val name: String,
    val image: ImageResponse,
    val categories: List<String>,
    val description: CoinDescriptionResponse
)

data class CoinDescriptionResponse(
    val en: String
)

data class ImageResponse(
    val thumb: String,
    val small: String,
    val large: String
)