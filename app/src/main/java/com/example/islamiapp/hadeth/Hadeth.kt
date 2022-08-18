package com.example.islamiapp.hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.R
import com.example.islamiapp.constant

class hadeth : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adaptor: hadehAdaptor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hadeth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    fun initView() {
        recyclerView = requireView().findViewById(R.id.hadeth_RV)
        initList()
        adaptor = hadehAdaptor(hadeth)
        recyclerView.adapter = adaptor
        adaptor.onItemSelectListener = object : hadehAdaptor.OnItemSelectListener {
            override fun onItemClick(position: Int, hadeth: String) {
                val intent = Intent(requireContext(), hadeth_details()::class.java)
                    .putExtra(constant.HADETH_NAME, hadeth)
                    .putExtra(constant.HADETH_POSTION, position)

                startActivity(intent)

            }
        }

    }

    lateinit var hadeth: MutableList<String>
    fun initList() {
        hadeth = mutableListOf()
        for (i in 1..50) {
            hadeth.add(
                "حديث رقم $i"
            )
        }

    }


}