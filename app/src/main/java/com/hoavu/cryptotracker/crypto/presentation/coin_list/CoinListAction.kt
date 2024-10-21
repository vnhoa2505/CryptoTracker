package com.hoavu.cryptotracker.crypto.presentation.coin_list

import com.hoavu.cryptotracker.crypto.presentation.models.CoinUI

sealed interface CoinListAction {
    data class OnCoinClick(val coinUI: CoinUI) : CoinListAction
    data object OnRefresh : CoinListAction
}