package com.raj.pagingexample2

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.raj.pagingexample2.quotesource.QuotePagingSource
import com.raj.pagingexample2.retrofit.QuoteApi

class QuoteRepositary(private val quoteApi: QuoteApi) {

    fun getQuotes() = Pager(
        config = PagingConfig(20,50),
        pagingSourceFactory = { QuotePagingSource(quoteApi) }
    ).liveData

}