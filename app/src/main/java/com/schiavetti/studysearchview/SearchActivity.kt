package com.schiavetti.studysearchview

import android.app.SearchManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        println("Kfk: Query is ${intent.getStringExtra(SearchManager.QUERY)}")
    }
}
