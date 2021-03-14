package com.phong.mvvmretrofit.data.source.remote

import com.phong.mvvmretrofit.data.model.RecipeResponse
import com.phong.mvvmretrofit.data.source.DataSource
import com.phong.mvvmretrofit.data.source.remote.api.ApiClient
import retrofit2.Response

class RemoteDataSource : DataSource.Remote {

    override suspend fun getRecipe(): Response<RecipeResponse> {
        return ApiClient.apiService.getRecipe()
    }

    companion object {
        fun newInstance() = RemoteDataSource()
    }
}
