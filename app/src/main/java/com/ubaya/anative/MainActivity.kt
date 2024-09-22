package com.ubaya.anative

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.ubaya.anative.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btn_game2)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//
        binding.btnOurSchedule.setOnClickListener(){
            val Intent = Intent(this, ScheduleDetail::class.java)
            startActivity(Intent)
        }

        binding.btnWhoweare.setOnClickListener(){
            val klik = Intent(this, WhoWeAre::class.java)
            startActivity(klik)
        }

        binding.btnPlay.setOnClickListener(){
            val Intent = Intent(this, WhatWePlayList::class.java)
            startActivity(Intent)
        }
    }
}