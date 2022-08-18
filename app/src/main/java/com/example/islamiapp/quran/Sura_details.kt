package com.example.islamiapp.quran

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.R
import com.example.islamiapp.constant

class sura_details : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adaptor: suraDetailsAdaptor
    lateinit var suraTile: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        suraTile = findViewById(R.id.sura_title)
        initView()
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    fun initList(fileName: String): List<String> {
        val fileContent = assets.open(fileName).bufferedReader().use { it.readText() }
        val suraDetails = fileContent.split('\n')
        return suraDetails
    }

    fun initView() {
        var suraName = intent.getStringExtra(constant.SURA_NAME)
        var suraPos = intent.getIntExtra(constant.SURA_POSTION, -1)
        recyclerView = findViewById(R.id.sura_details_RV)
        adaptor = suraDetailsAdaptor()
        adaptor.initList(initList("sura/${suraPos + 1}.txt"))
        recyclerView.adapter = adaptor
        suraTile.text = suraName

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
