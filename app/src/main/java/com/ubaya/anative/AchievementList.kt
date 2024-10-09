package com.ubaya.anative

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.anative.databinding.ActivityAchievementListBinding
import com.ubaya.anative.databinding.ActivityWhatWePlayListBinding

//class AchievementList : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_achievement_list)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//    }
//}


//
//class AchievementList : AppCompatActivity() {
//
//    private lateinit var binding: ActivityAchievementListBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        binding = ActivityAchievementListBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
////        binding.recQuestion.layoutManager = LinearLayoutManager(this)
////        binding.recQuestion.setHasFixedSize(true)
////        binding.recQuestion.adapter = QuestionAdapter()
//
//        binding.recAchievement.layoutManager = LinearLayoutManager(this)
//        binding.recAchievement.setHasFixedSize(true)
//        binding.recAchievement.adapter = GameAdapter()
//
//
////        setContentView(R.layout.activity_what_we_play_list)
////        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
////            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
////            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
////            insets
////        }
//    }
//}