package com.ubaya.anative

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.ubaya.anative.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOurSchedule.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("home_index", 2)
            startActivity(intent)
        }

        binding.btnWhoweare.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("home_index", 1)
            startActivity(intent)
        }

        binding.btnPlay.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("home_index", 0)
            startActivity(intent)
        }
    }
}
