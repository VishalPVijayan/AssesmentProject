package com.vishalpvijayan.assesmentproject

import androidx.annotation.NonNull
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val BASE_URL = "https://picsum.photos/"
interface DataApi {
    @GET("v2/list?")

    //suspending function Coroutines
    suspend fun getMovies(@NonNull @Query("page") page: Int?,
                          @Query("limit") limit: Int?):
            Response<List<DataResponse>>


    companion object{
        operator fun invoke() : DataApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(DataApi::class.java)
        }
    }
}

