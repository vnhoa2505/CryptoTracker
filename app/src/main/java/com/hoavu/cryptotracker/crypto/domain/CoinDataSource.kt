package com.hoavu.cryptotracker.crypto.domain

import com.hoavu.cryptotracker.core.domain.util.NetworkError
import com.hoavu.cryptotracker.core.domain.util.Result

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
}