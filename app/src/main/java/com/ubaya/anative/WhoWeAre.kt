package com.ubaya.anative

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.ubaya.anative.databinding.ActivityWhoWeAreBinding

class WhoWeAre : AppCompatActivity() {

    private lateinit var binding : ActivityWhoWeAreBinding;
    var Jlike = 0;
    fun Like() {
        if (Jlike >= 0) {
            Jlike += 1
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWhoWeAreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtLike.text = "0";

        binding.btnLike.setOnClickListener {
            Like()
            binding.txtLike.text = Jlike.toString()
        }

        enableEdgeToEdge()
//        setContentView(R.layout.activity_who_we_are)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btn_game2)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}