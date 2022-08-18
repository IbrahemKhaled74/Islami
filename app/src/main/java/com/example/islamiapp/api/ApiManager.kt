package com.example.islamiapp.api

import com.example.islamiapp.constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {
    companion object {
        var retrofit: Retrofit? = null

        private fun getInstance(): Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(constant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!

        }

        fun getApi(): WebServices {
            return getInstance().create(WebServices::class.java)
        }
    }

}