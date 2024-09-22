package com.ubaya.anative

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.anative.databinding.ActivityWhatWePlayListBinding

class WhatWePlayList : AppCompatActivity() {

    private lateinit var binding: ActivityWhatWePlayListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityWhatWePlayListBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.recQuestion.layoutManager = LinearLayoutManager(this)
//        binding.recQuestion.setHasFixedSize(true)
//        binding.recQuestion.adapter = QuestionAdapter()

        binding.recGame.layoutManager = LinearLayoutManager(this)
        binding.recGame.setHasFixedSize(true)
        binding.recGame.adapter = GameAdapter()


//        setContentView(R.layout.activity_what_we_play_list)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}