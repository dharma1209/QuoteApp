package com.raj.pagingexample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.raj.pagingexample2.adapter.QuotePagingAdapter
import com.raj.pagingexample2.retrofit.NetworkModule
import com.raj.pagingexample2.retrofit.QuoteApi
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var adapter: QuotePagingAdapter
    lateinit var viewModel: QuoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Quote App"
        adapter = QuotePagingAdapter(this)
        val quotesService = NetworkModule().getRetrofit().create(QuoteApi::class.java)
        val quoteRepositary = QuoteRepositary(quotesService)
        viewModel = ViewModelProvider(this,QuoteViewModelFactory(quoteRepositary))[QuoteViewModel::class.java]

        viewPager2.adapter = adapter

        viewModel.quoteList.observe(this, Observer {
            adapter.submitData(lifecycle,it)
        })
    }
}