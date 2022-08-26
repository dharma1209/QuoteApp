package com.raj.pagingexample2.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.raj.pagingexample2.R
import com.raj.pagingexample2.models.ResultsItem

class QuotePagingAdapter(val context: Context):PagingDataAdapter<ResultsItem, QuotePagingAdapter.QuoteViewHolder>(
    COMPARATOR
) {

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val data = getItem(position)
        if (data != null){
            holder.quoteText.text = data.content
        }
        holder.shareButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT,data?.content)
            val chooser = Intent.createChooser(intent,"Share This Quote..")
            context.startActivity(chooser)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quote_list_items,parent,false)
        return QuoteViewHolder(view)
    }
    class QuoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val quoteText:TextView = itemView.findViewById(R.id.quote_text)
        val shareButton:ImageView = itemView.findViewById(R.id.shareButton)
    }

    companion object {
        private val COMPARATOR = object :DiffUtil.ItemCallback<ResultsItem>(){
            override fun areItemsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
                return oldItem.Id == newItem.Id
            }

            override fun areContentsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}