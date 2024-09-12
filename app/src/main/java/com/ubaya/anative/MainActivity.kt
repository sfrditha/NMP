package com.ubaya.anative

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btn_game2)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val buttonPlay = findViewById<ImageView>(R.id.btn_play)
        buttonPlay.setOnClickListener{
            val Intent = Intent(this,whatWePlay::class.java)
            startActivity(Intent)
        }

        val buttonWhoWeAre = findViewById<ImageView>(R.id.btn_whoweare)
        buttonWhoWeAre.setOnClickListener{
            val Intent = Intent(this,whoWeAre::class.java)
            startActivity(Intent)
        }

        val buttonSchedule = findViewById<ImageView>(R.id.btn_ourSchedule)
        buttonSchedule.setOnClickListener{
            val Intent = Intent(this,schedule::class.java)
            startActivity(Intent)
        }

    }
}