package com.phong.mvvmretrofit.data.source

import com.phong.mvvmretrofit.data.model.RecipeResponse
import retrofit2.Response

interface DataSource {
    interface Remote{
         suspend fun getRecipe(): Response<RecipeResponse>
    }
}
