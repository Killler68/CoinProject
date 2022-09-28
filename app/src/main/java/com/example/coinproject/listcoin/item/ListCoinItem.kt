package com.example.coinproject.listcoin.item

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.coinproject.R
import com.example.coinproject.databinding.RecyclerItemListCoinBinding
import com.example.coinproject.listcoin.model.CoinData
import com.mikepenz.fastadapter.binding.AbstractBindingItem

class ListCoinItem(
    private val coinData: CoinData,
    private val onClick: (String) -> Unit
) : AbstractBindingItem<RecyclerItemListCoinBinding>() {

    @SuppressLint("SetTextI18n")
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
            textCoinCourseItem.text = coinData.current_price.toString()
            if (coinData.market_cap_change_percentage_24h > 0) {
                binding.textCoinCoursePercentItem.setTextColor(Color.GREEN)
            } else {
                binding.textCoinCoursePercentItem.setTextColor(Color.RED)
            }
            textCoinCoursePercentItem.text = "${coinData.market_cap_change_percentage_24h}%"
        }
    }

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): RecyclerItemListCoinBinding =
        RecyclerItemListCoinBinding.inflate(inflater, parent, false)

    override val type: Int = R.id.background_coin_item
}