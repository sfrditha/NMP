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
        binding.btnPlay.setOnClickListener(){
            val Intent = Intent(this,WhatWePlay::class.java)
            startActivity(Intent)
        }
//        val buttonPlay = findViewById<ImageView>(R.id.btn_play)
//        buttonPlay.setOnClickListener{
//            val Intent = Intent(this,whatWePlay::class.java)
//            startActivity(Intent)
//        }
        binding.btnOurSchedule.setOnClickListener(){
            val Intent = Intent(this, ScheduleDetail::class.java)
            startActivity(Intent)
        }

        binding.btnWhoweare.setOnClickListener(){
            val Intent = Intent(this,WhoWeAre::class.java)
            startActivity(Intent)
        }
//        val buttonWhoWeAre = findViewById<ImageView>(R.id.btn_whoweare)
//        buttonWhoWeAre.setOnClickListener{
//            val Intent = Intent(this,whoWeAre::class.java)
//            startActivity(Intent)
//        }

//        val buttonSchedule = findViewById<ImageView>(R.id.btn_ourSchedule)
//        buttonSchedule.setOnClickListener{
//            val Intent = Intent(this, ScheduleDetail::class.java)
//            startActivity(Intent)
//
//        }

    }
}