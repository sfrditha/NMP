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

        val user_id = intent.getIntExtra("user_id",0)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOurSchedule.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("home_index", 2)
            intent.putExtra("user_id", user_id)
            startActivity(intent)
        }

        binding.btnWhoweare.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("home_index", 1)
            intent.putExtra("user_id", user_id)
            startActivity(intent)
        }

        binding.btnPlay.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("home_index", 0)
            intent.putExtra("user_id", user_id)
            startActivity(intent)
        }
    }
}
