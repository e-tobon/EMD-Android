package com.avv.cardiologoapp.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.avv.cardiologoapp.core.Results
import com.avv.cardiologoapp.repository.FireBaseRepository
import kotlinx.coroutines.Dispatchers

class cardioViewModel(private val repo:FireBaseRepository): ViewModel() {

    fun fetchCardioValues() =
        liveData(Dispatchers.IO) {
            emit(Results.Loading())
            try{
                emit(Results.Success(repo.getCardioValues()))

            }catch (e:Exception){
                emit(Results.Failure(e))
            }
        }
}

class CardioViewModelFactory(private val repo: FireBaseRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(FireBaseRepository::class.java).newInstance(repo)
    }
}