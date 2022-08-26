package com.raj.pagingexample2.retrofit

import com.raj.pagingexample2.models.QuoteList
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteApi {

    @GET("quotes")
    suspend fun getQuotes(@Query("page") page:Int): QuoteList

}