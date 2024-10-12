package com.ubaya.anative

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ubaya.anative.databinding.ActivityAchievementsBinding
import com.ubaya.anative.databinding.ActivityMainBinding

class AchievementsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAchievementsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAchievementsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val index = intent.getIntExtra("game_index",0)

        val items = arrayOf("All", "2024", "2023", "2022")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        val achievementsList: MutableList<Achievements> = mutableListOf()

        binding.imgGame.setImageResource(GameData.gamesData[index].imageId)
        achievementsList.addAll(GameData.gamesData[index].achievements)
        binding.txtTitleAch.text = "${GameData.gamesData[index].name} Achievements"

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spnYear.adapter = adapter;

        binding.spnYear.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>, view: View?, position: Int, id: Long
            ) {

                val selectedYear = parent.getItemAtPosition(position).toString()


                val filteredAchievements = if (selectedYear == "All") {
                    achievementsList
                } else {
                    achievementsList.filter { it.year.toString() == selectedYear }
                }


                displayAchievements(filteredAchievements)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

//        setContentView(R.layout.activity_achievements)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
    private fun displayAchievements(achievements: List<Achievements>) {
        val achievementText = achievements.mapIndexed { index, achievement ->
            "${index + 1}. ${achievement.title} (${achievement.year})"
        }.joinToString("\n")

        binding.txtDescAch.text = achievementText
    }
}