package com.phong.mvvmretrofit.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.phong.mvvmretrofit.utils.Resource
import com.phong.mvvmretrofit.data.source.Repository
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {

    private val repository = Repository.newInstance()

    fun getRecipe() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getRecipe()))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error Occurred!"))
        }
    }
}

