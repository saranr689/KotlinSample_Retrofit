package com.kotlinsample

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WebApiCall {
    @GET("api.php")
    fun hitCountCheck(@Query("action") action: String,
                      @Query("format") format: String,
                      @Query("list") list: String,
                      @Query("srsearch") srsearch: String): Call<Model>

}