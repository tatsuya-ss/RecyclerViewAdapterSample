package com.example.recyclerviewadaptersample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewadaptersample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), RecyclerViewHolderListener {

    private lateinit var binding: ActivityMainBinding
    private val names: MutableList<String> = mutableListOf(
        "A", "B", "C", "D", "E"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupRecyclerView()

    }

    private fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    private fun setupRecyclerView() {
        binding.recyclerView.adapter = RecyclerViewAdapter(names, this)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onClickRow(name: String) {
        println(name)
    }

}
