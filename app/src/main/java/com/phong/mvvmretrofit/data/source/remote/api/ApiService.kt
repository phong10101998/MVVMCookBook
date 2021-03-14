package com.phong.mvvmretrofit.data.source.remote.api

import com.phong.mvvmretrofit.data.model.RecipeResponse
import com.phong.mvvmretrofit.utils.Constant
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(Constant.RANDOM)
    suspend fun getRecipe() : Response<RecipeResponse>
}
