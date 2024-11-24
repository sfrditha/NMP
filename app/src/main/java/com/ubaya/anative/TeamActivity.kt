package com.ubaya.anative

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.anative.databinding.ActivityTeamBinding
import org.json.JSONObject

class TeamActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTeamBinding
    private var teamsList: ArrayList<Teams> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inflate the layout
        binding = ActivityTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve the game_id from the Intent
        val gameId = intent.getIntExtra("game_index", 0)

        // Fetch teams based on game_id
        fetchTeams(gameId)
    }

    private fun fetchTeams(gameId: Int) {
        val url = "https://ubaya.xyz/native/160722042/get_team.php" // Update URL to match your server
        val queue = Volley.newRequestQueue(this)

        val stringRequest = object : StringRequest(
            Request.Method.POST, url,
            Response.Listener { response ->
                Log.d("apiresult", response)
                val obj = JSONObject(response)

                if (obj.getString("result") == "OK") {
                    val data = obj.getJSONArray("data")
                    val teamsType = object : TypeToken<ArrayList<Teams>>() {}.type
                    teamsList = Gson().fromJson(data.toString(), teamsType)

                    // Update UI with fetched teams
                    displayTeams(teamsList)
                } else {
                    Toast.makeText(this, "No teams found.", Toast.LENGTH_SHORT).show()
                }
            },
            Response.ErrorListener { error ->
                Log.e("apiresult", error.message.toString())
                Toast.makeText(this, "Error fetching teams.", Toast.LENGTH_SHORT).show()
            }
        ) {
            override fun getParams(): MutableMap<String, String> {
                return hashMapOf("team_id" to gameId.toString())
            }
        }
        queue.add(stringRequest)
    }

    private fun displayTeams(teams: List<Teams>) {
        // Check if we have at least 3 teams
        if (teams.size >= 3) {
            binding.btnTeamA.text = teams[0].nama
            binding.btnTeamB.text = teams[1].nama
            binding.btnTeamC.text = teams[2].nama

            // Set onClickListeners for each button
            binding.btnTeamA.setOnClickListener {
                navigateToDetail(teams[0])
            }
            binding.btnTeamB.setOnClickListener {
                navigateToDetail(teams[1])
            }
            binding.btnTeamC.setOnClickListener {
                navigateToDetail(teams[2])
            }
        } else {
            Toast.makeText(this, "Gagal mengambil data", Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateToDetail(team: Teams) {
        val intent = Intent(this, DetailTeamList::class.java)
        intent.putExtra("team_name", team.nama)
        intent.putExtra("team_id", team.id)
        startActivity(intent)
    }
}
