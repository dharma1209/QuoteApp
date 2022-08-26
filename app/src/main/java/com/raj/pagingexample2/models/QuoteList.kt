package com.raj.pagingexample2.models

data class QuoteList(val count: Int = 0,
                     val totalPages: Int = 0,
                     val lastItemIndex: Int = 0,
                     val page: Int = 0,
                     val totalCount: Int = 0,
                     val results: List<ResultsItem>?)