package com.ubaya.anative

import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.squareup.picasso.Picasso
import com.ubaya.anative.databinding.ActivityAchievementsBinding
import org.json.JSONObject

class AchievementsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAchievementsBinding
    private var achievementsList: ArrayList<Achievements> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding
        binding = ActivityAchievementsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get data from Intent
        val gameId = intent.getIntExtra("game_index", 0)
        val gameImageUrl = intent.getStringExtra("game_image_url")
        val gameTitle = intent.getStringExtra("game_title") ?: "Game Achievements"

        // Set image and title
        binding.txtTitleAch.text = "$gameTitle Achievements"
        Picasso.get().load(gameImageUrl).into(binding.imgGame)

        // Fetch achievements data
        fetchAchievements(gameId)

        // Configure Spinner for years
        val items = arrayOf("All", "2024", "2023", "2022")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spnYear.adapter = adapter

        binding.spnYear.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>, view: android.view.View?, position: Int, id: Long) {
                val selectedYear = items[position]
                val filteredAchievements = if (selectedYear == "All") {
                    achievementsList
                } else {
                    achievementsList.filter { it.year.toString() == selectedYear }
                }
                displayAchievements(filteredAchievements)
            }

            override fun onNothingSelected(parentView: AdapterView<*>) {
                // Optional: Handle the case where nothing is selected, if needed
            }
        }
    }

    private fun fetchAchievements(gameId: Int) {
        val url = "https://ubaya.xyz/native/160722042/get_achievement.php"
        val queue = Volley.newRequestQueue(this)

        val stringRequest = object : StringRequest(
            Request.Method.POST, url,
            Response.Listener { response ->
                Log.d("apiresult", response)
                val obj = JSONObject(response)
                if (obj.getString("result") == "OK") {
                    val data = obj.getJSONArray("data")
                    val achievementsType = object : TypeToken<ArrayList<Achievements>>() {}.type
                    achievementsList = Gson().fromJson(data.toString(), achievementsType)
                    displayAchievements(achievementsList)
                } else {
                    binding.txtDescAch.text = "No achievements found."
                }
            },
            Response.ErrorListener { error ->
                Log.e("apiresult", error.message.toString())
                binding.txtDescAch.text = "Error fetching achievements."
            }
        ) {
            override fun getParams(): MutableMap<String, String> {
                return hashMapOf("game_id" to gameId.toString())
            }
        }
        queue.add(stringRequest)
    }

    private fun displayAchievements(achievements: List<Achievements>) {
        if (achievements.isEmpty()) {
            binding.txtDescAch.text = "No achievements found for the selected year."
        } else {
            val achievementText = achievements.joinToString("\n") { achievement ->
                "${achievement.title} (${achievement.year})"
            }
            binding.txtDescAch.text = achievementText
        }
    }
}
