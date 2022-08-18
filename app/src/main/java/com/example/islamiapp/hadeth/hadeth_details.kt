package com.example.islamiapp.hadeth

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.R
import com.example.islamiapp.constant

class hadeth_details : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adaptor: hadethDetailsAdaptor
    lateinit var hadethTitle: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hadeth_details)
        hadethTitle = findViewById(R.id.hadeth_title)
        initView()
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    fun initList(fileName: String): List<String> {
        val fileContent = assets.open(fileName).bufferedReader().use { it.readText() }
        val hadethDetails = fileContent.split('\n')
        return hadethDetails
    }

    fun initView() {
        var hadethName = intent.getStringExtra(constant.HADETH_NAME)
        var hadethPos = intent.getIntExtra(constant.HADETH_POSTION, -1)
        recyclerView = findViewById(R.id.hadeth_details_RV)
        adaptor = hadethDetailsAdaptor()
        adaptor.initList(initList("hadeth/h${hadethPos + 1}.txt"))
        recyclerView.adapter = adaptor
        hadethTitle.text = hadethName

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
