package com.marlena.agenda.service

import android.arch.persistence.room.Room
import android.content.Context
import android.util.Log
import com.marlena.agenda.data.Cache
import com.marlena.agenda.model.Contact
import com.marlena.agenda.model.WeatherResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class WeatherClient {

    companion object { //singleton - only one instance
        lateinit var instance: WeatherClient
            private set

        fun initialize() {
            instance = WeatherClient()
            instance.retrofit = Retrofit.Builder()
                .baseUrl(Cache.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherApi::class.java)
        }
    }

    private lateinit var retrofit: WeatherApi

    fun getCurrentWeatherData(lat: String, lon: String): WeatherResponse? {
        val call = retrofit.getCurrentWeatherData(lat, lon, Cache.AppId)
        try {
            val response = call.execute()
            if (response.isSuccessful) {
                Log.d("LENA", "getWeatherData successful: ${response.body()?.toString()}")
                return response.body()
            } else {
                Log.d("LENA", "getWeatherData Response Error: ${response.errorBody()?.toString()}")
            }
        } catch (e: IOException) {
            Log.e("LENA", e.message)
        } catch (e: RuntimeException) {
            Log.e("LENA", e.message)
        }

        return null
    }
}