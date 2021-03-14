package com.phong.mvvmretrofit.data.source

import com.phong.mvvmretrofit.data.source.remote.RemoteDataSource
import com.phong.mvvmretrofit.data.source.remote.api.ApiClient

class Repository private constructor(private val remote: DataSource.Remote) {

    suspend fun getRecipe() = remote.getRecipe()

    companion object {
        fun newInstance() = Repository(RemoteDataSource.newInstance())
    }
}
