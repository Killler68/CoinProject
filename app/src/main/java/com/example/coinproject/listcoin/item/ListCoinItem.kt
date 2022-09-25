package com.example.coinproject.listcoin.item

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.coinproject.R
import com.example.coinproject.databinding.RecyclerItemListCoinBinding
import com.example.coinproject.listcoin.model.CoinData
import com.mikepenz.fastadapter.binding.AbstractBindingItem

class ListCoinItem(
    private val coinData: CoinData,
    private val onClick: (String) -> Unit
) : AbstractBindingItem<RecyclerItemListCoinBinding>() {


    override fun bindView(binding: RecyclerItemListCoinBinding, payloads: List<Any>) {
        super.bindView(binding, payloads)


        with(binding) {

            backgroundCoinItem.setOnClickListener {
                onClick(coinData.coinName)
            }

            imageCoinItem.text = coinData.coinImage
            textCoinItem.text = coinData.coinName
            textCoinAbbreviatedItem.text = coinData.coinAbbreviated
            textCoinCourseItem.text = coinData.coinCourse.toString()
            textCoinCoursePercentItem.text = coinData.coinCoursePercent.toString()
        }
    }

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): RecyclerItemListCoinBinding =
        RecyclerItemListCoinBinding.inflate(inflater, parent, false)

    override val type: Int = R.id.background_coin_item
}