package com.avv.cardiologoapp.repository

import com.avv.cardiologoapp.data.cardioValue
import com.avv.cardiologoapp.data.remote.cardioDataSource


class FireBaseImp(private val dataSource: cardioDataSource):FireBaseRepository {
    override suspend fun getCardioValues(): cardioValue = dataSource.getCardioValues()
}