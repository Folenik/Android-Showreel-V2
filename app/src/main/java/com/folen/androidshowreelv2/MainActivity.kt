package com.folen.androidshowreelv2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val itemsList = ArrayList<TestListItem>()
    private lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        mainAdapter = MainAdapter(itemsList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = mainAdapter

        populateRecyclerView()
    }

    private fun populateRecyclerView() {
        val item1 = TestListItem("Header 1", "Description 1", R.drawable.ic_launcher_background)
        val item2 = TestListItem("Header 2", "Description 2", R.drawable.ic_launcher_background)
        val item3 = TestListItem("Header 3", "Description 3", R.drawable.ic_launcher_background)
        val item4 = TestListItem("Header 4", "Description 4", R.drawable.ic_launcher_background)

        itemsList.add(item1)
        itemsList.add(item2)
        itemsList.add(item3)
        itemsList.add(item4)

        mainAdapter.notifyDataSetChanged()

        //setup GSON
    }
}