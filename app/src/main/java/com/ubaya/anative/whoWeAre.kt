package com.ubaya.anative

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ubaya.anative.databinding.ActivityWhoWeAreBinding

class whoWeAre : AppCompatActivity() {

    private lateinit var binding : ActivityWhoWeAreBinding;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWhoWeAreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtLike.text = "100";

        enableEdgeToEdge()
//        setContentView(R.layout.activity_who_we_are)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btn_game2)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}