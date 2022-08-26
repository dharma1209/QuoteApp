package com.raj.pagingexample2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class QuoteViewModel (private val quoteRepositary: QuoteRepositary): ViewModel() {

    val quoteList = quoteRepositary.getQuotes().cachedIn(viewModelScope)
}