package com.raj.pagingexample2.quotesource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.raj.pagingexample2.models.ResultsItem
import com.raj.pagingexample2.retrofit.QuoteApi

class QuotePagingSource(val quoteApi: QuoteApi): PagingSource<Int,ResultsItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResultsItem> {
        return try {
            val position = params.key?: 1
            val response = quoteApi.getQuotes(position)
            LoadResult.Page(
                data = response.results!!,
                prevKey = if (position == 1) null else position -1,
                nextKey = if (position == response.totalPages) null else position + 1
            )
        } catch (e:Exception){
            LoadResult.Error(e)

        }
    }
    override fun getRefreshKey(state: PagingState<Int, ResultsItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}