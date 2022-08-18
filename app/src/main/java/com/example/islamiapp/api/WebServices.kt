package com.example.islamiapp.api

import retrofit2.http.GET

interface WebServices {
    @GET("radio_ar.json")
    suspend fun getRadioList(): RadioResponse
}