package com.example.soptin.network

import android.util.Log
import com.example.soptin.BuildConfig
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Retrofit

object ApiFactory {

    private fun getLogOkHttpClient(): Interceptor {

        val interceptor = HttpLoggingInterceptor { message ->
            when {
                message.isJsonObject() ->
                    Log.d("Retrofit2", JSONObject(message).toString(4))
                message.isJsonArray() ->
                    Log.d("Retrofit2", JSONArray(message).toString(4))
                else -> {
                    Log.d("Retrofit2", "CONNECTION INFO -> $message")
                }
            }
        }
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    fun String?.isJsonObject(): Boolean = this?.startsWith("{") == true && this.endsWith("}")
    fun String?.isJsonArray(): Boolean = this?.startsWith("[") == true && this.endsWith("]")

    private val client = OkHttpClient.Builder()
        .addInterceptor(getLogOkHttpClient())
        .build()

    val testAPI: Retrofit by lazy {
        Retrofit.Builder().baseUrl(BuildConfig.SOPTIN_BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .client(client).build()
    }

    inline fun <reified T> createAuthService(): T = testAPI.create<T>(T::class.java)

}

object ServicePool {
    val routineApiService = ApiFactory.createAuthService<RoutineApiService>()
}