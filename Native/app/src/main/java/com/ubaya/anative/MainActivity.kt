package com.ubaya.anative

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Tombol About Us
        val aboutUsButton = findViewById<Button>(R.id.btnAboutUs)
        aboutUsButton.setOnClickListener {
            val intent = Intent(this, aboutUs::class.java)
            startActivity(intent)
        }

        // Tombol Schedule E-Sport
        val scheduleButton = findViewById<Button>(R.id.btnSchedule)
        scheduleButton.setOnClickListener {
            val intent = Intent(this, schedule::class.java)
            startActivity(intent)
        }
    }
}