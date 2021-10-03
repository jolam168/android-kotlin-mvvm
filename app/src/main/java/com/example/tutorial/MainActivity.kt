package com.example.tutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: SearchViewModel

    lateinit var mAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        var searchView = findViewById<SearchView>(R.id.search_view)
        searchView.setOnQueryTextListener(SearchViewListener(viewModel))
        searchView.setIconifiedByDefault(false)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        mAdapter = UserAdapter()
        recyclerView.adapter = mAdapter

        viewModel.userListLiveData.observe(this, Observer {
            (recyclerView.adapter as UserAdapter).setList(it)
        })
    }

    class SearchViewListener(private val viewModel: SearchViewModel) :
        SearchView.OnQueryTextListener {
        override fun onQueryTextChange(newText: String): Boolean {
            viewModel.searchUser(newText)
            return false
        }

        override fun onQueryTextSubmit(query: String): Boolean {
            viewModel.searchUser(query)
            return false
        }
    }
}

