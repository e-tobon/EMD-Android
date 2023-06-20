package com.avv.cardiologoapp.data.remote

import com.avv.cardiologoapp.data.cardioValue
import com.avv.cardiologoapp.repository.webService

class cardioDataSource(private val webService: webService) {
    suspend fun getCardioValues(): cardioValue = webService.getCardioValues()
}