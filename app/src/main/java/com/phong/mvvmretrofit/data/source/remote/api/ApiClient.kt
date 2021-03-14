package com.phong.mvvmretrofit.data.source.remote.api

import com.phong.mvvmretrofit.utils.Constant
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private fun callApi(): Retrofit {
        val builder = OkHttpClient.Builder()
        builder.interceptors().add(AuthenticationInterceptor())
        val client = builder.build()
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val apiService: ApiService = callApi().create(ApiService::class.java)
}
