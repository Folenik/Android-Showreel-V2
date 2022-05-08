package com.folen.androidshowreelv2

import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.folen.androidshowreelv2.utilities.Constants.LIST_JSON_NAME
import com.folen.androidshowreelv2.utilities.managers.AssetsManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    private var featureList = ArrayList<Feature>()
    private lateinit var featureListAdapter: FeatureListAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        if (populateFeatureList()) {
            recyclerView = findViewById(R.id.recyclerView)
            featureListAdapter = FeatureListAdapter(featureList)
            val layoutManager = LinearLayoutManager(applicationContext)
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = featureListAdapter
        } else {
            Toast.makeText(applicationContext, R.string.feature_recyclerview_error, LENGTH_LONG)
                .show()
        }
    }

    private fun populateFeatureList(): Boolean {
        return try {
            val featureListJson: String? = AssetsManager.loadJsonFromAssets(this, LIST_JSON_NAME)
            featureList = Gson().fromJson<List<Feature>>(
                featureListJson, object : TypeToken<List<Feature?>?>() {}.type
            ) as ArrayList<Feature>
            true
        } catch (ex: Exception) {
            ex.printStackTrace()
            false
        }
    }
}