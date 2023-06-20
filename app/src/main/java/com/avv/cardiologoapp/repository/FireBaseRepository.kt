package com.avv.cardiologoapp.repository

import com.avv.cardiologoapp.data.cardioValue

interface FireBaseRepository {
    suspend fun getCardioValues(): cardioValue
}