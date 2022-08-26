package com.raj.pagingexample2.models

data class ResultsItem(val authorSlug: String = "",
                       val author: String = "",
                       val length: Int = 0,
                       val dateModified: String = "",
                       val Id: String = "",
                       val content: String = "",
                       val dateAdded: String = "",
                       val tags: List<String>?)