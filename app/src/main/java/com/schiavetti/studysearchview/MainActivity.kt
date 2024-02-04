package com.schiavetti.studysearchview

import android.app.SearchManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import com.schiavetti.studysearchview.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import com.google.android.material.search.SearchBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val query = intent?.getStringExtra(SearchManager.QUERY)
        println("Kfk: Query is $query")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        setupSearchableInfo((menu?.findItem(R.id.search)?.actionView as SearchView))
        return true
    }

    private fun setupSearchableInfo(searchView: SearchView) {
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchableInfo =
            searchManager.getSearchableInfo(ComponentName(this, SearchActivity::class.java))
        searchView.setSearchableInfo(searchableInfo)
        searchView.setupQueryListeners()
    }

    private fun SearchView.setupQueryListeners() {
        setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                println("Kfk: Submitting query with text: $query")
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                println("Kfk: Current query is: $newText")
                return false
            }
        })
    }
}
