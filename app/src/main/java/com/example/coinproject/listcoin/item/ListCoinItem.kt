package com.example.coinproject.listcoin.item

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.coinproject.R
import com.example.coinproject.databinding.RecyclerItemListCoinBinding
import com.example.coinproject.listcoin.model.CoinData
import com.mikepenz.fastadapter.binding.AbstractBindingItem


private const val NUMBER_COLOR_CHANGE = 0

class ListCoinItem(
    private val coinData: CoinData,
    private val onClick: (String) -> Unit
) : AbstractBindingItem<RecyclerItemListCoinBinding>() {

    override fun bindView(binding: RecyclerItemListCoinBinding, payloads: List<Any>) {
        super.bindView(binding, payloads)

        with(binding) {
            backgroundCoinItem.setOnClickListener {
                onClick(coinData.id)
            }
            Glide
                .with(binding.root)
                .load(coinData.image)
                .into(binding.imageCoinItem)

            textCoinItem.text = coinData.name
            textCoinAbbreviatedItem.text = coinData.symbol

            textCoinCourseItem.text = root.resources.getString(
                R.string.usd, coinData.current_price.toString()
            )
            if (coinData.market_cap_change_percentage_24h > NUMBER_COLOR_CHANGE) {
                binding.textCoinCoursePercentItem.setTextColor(Color.GREEN)
            } else {
                binding.textCoinCoursePercentItem.setTextColor(Color.RED)
            }
            textCoinCoursePercentItem.text = root.resources.getString(
                R.string.percentage, coinData.market_cap_change_percentage_24h.toString()
            )
        }
    }

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): RecyclerItemListCoinBinding =
        RecyclerItemListCoinBinding.inflate(inflater, parent, false)

    override val type: Int = R.id.background_coin_item
}