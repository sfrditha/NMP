package com.ubaya.anative

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.anative.databinding.ActivityApplyTeamBinding
import org.json.JSONObject

class ApplyTeamActivity : AppCompatActivity() {
    private lateinit var binding: ActivityApplyTeamBinding
    var games: ArrayList<Game> = ArrayList()
    var teams: ArrayList<Teams> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityApplyTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user_id = intent.getIntExtra("user_id", 0)

        // Nonaktifkan spinnerTeam saat awal
        binding.spinnerTeam.isEnabled = false
        binding.spinnerTeam.isClickable = false

        getGames()

        var description = binding.etDescription.text.toString()

        binding.spinnerGame.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>, view: android.view.View?, position: Int, id: Long) {
                val selectedGame = games[position]
                getTeams(user_id.toString(), selectedGame.id.toString())

                // Aktifkan spinnerTeam setelah memilih game
                binding.spinnerTeam.isEnabled = true
                binding.spinnerTeam.isClickable = true
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                // Tidak melakukan apa-apa
            }
        }

        binding.btnApply.setOnClickListener(){
            val selectedTeamIndex = binding.spinnerTeam.selectedItemPosition

            if (selectedTeamIndex >= 0) {
                val selectedTeam = teams[selectedTeamIndex]
                val description = binding.etDescription.text.toString()

                if (description.isNotBlank()) {
                    sendJoinProposal(user_id.toString(), selectedTeam.id.toString(), description)
                } else {
                    Toast.makeText(this, "Description cannot be empty.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please select a team.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun getGames() {
        val q = Volley.newRequestQueue(this)
        val url = "https://ubaya.xyz/native/160722042/get_game.php"

        val stringRequest = StringRequest(
            Request.Method.POST, url,
            {
                Log.d("apiresult", it)
                val obj = JSONObject(it)
                if (obj.getString("result") == "OK") {
                    val data = obj.getJSONArray("data")
                    val sType = object : TypeToken<List<Game>>() {}.type
                    games = Gson().fromJson(data.toString(), sType)

                    val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, games.map { it.name })
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    binding.spinnerGame.adapter = adapter
                }
            },
            {
                Log.e("apiresult", it.message.toString())
            }
        )
        q.add(stringRequest)
    }

    fun getTeams(user_id: String, game_id: String) {
        val queue = Volley.newRequestQueue(this)
        val url = "https://ubaya.xyz/native/160722042/get_nonTeam.php"

        val stringRequest = object : StringRequest(
            Request.Method.POST, url,
            Response.Listener { response ->
                Log.d("apiresult", response)
                val obj = JSONObject(response)

                if (obj.getString("result") == "OK") {
                    val data = obj.getJSONArray("data")
                    val teamsType = object : TypeToken<ArrayList<Teams>>() {}.type
                    teams = Gson().fromJson(data.toString(), teamsType)

                    if (teams.isNotEmpty()) {
                        val teamAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, teams.map { it.nama })
                        teamAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                        binding.spinnerTeam.adapter = teamAdapter

                        // Aktifkan spinnerTeam
                        binding.spinnerTeam.isEnabled = true
                        binding.spinnerTeam.isClickable = true
                    } else {
                        Toast.makeText(this, "No teams found.", Toast.LENGTH_SHORT).show()
                        binding.spinnerTeam.isEnabled = false
                        binding.spinnerTeam.isClickable = false
                    }
                } else {
                    Toast.makeText(this, "Error fetching teams.", Toast.LENGTH_SHORT).show()
                    binding.spinnerTeam.isEnabled = false
                    binding.spinnerTeam.isClickable = false
                }
            },
            Response.ErrorListener { error ->
                Log.e("apiresult", error.message.toString())
                Toast.makeText(this, "Error fetching teams.", Toast.LENGTH_SHORT).show()
                binding.spinnerTeam.isEnabled = false
                binding.spinnerTeam.isClickable = false
            }
        ) {
            override fun getParams(): MutableMap<String, String> {
                return hashMapOf("user_id" to user_id, "game_id" to game_id)
            }
        }
        queue.add(stringRequest)
    }

    fun sendJoinProposal(user_id: String, team_id: String, description: String) {
        val queue = Volley.newRequestQueue(this)
        val url = "https://ubaya.xyz/native/160722042/joinProposal.php"

        val stringRequest = object : StringRequest(
            Request.Method.POST, url,
            Response.Listener { response ->
                Log.d("apiresult", response)
                val obj = JSONObject(response)

                if (obj.getString("result") == "OK") {
                    Toast.makeText(this, "Join proposal sent successfully.", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, ProposalActivity::class.java)
                    intent.putExtra("user_id", user_id)
                    startActivity(intent)

                } else {
                    Toast.makeText(this, "Failed to send join proposal.", Toast.LENGTH_SHORT).show()
                }
            },
            Response.ErrorListener { error ->
                Log.e("apiresult", error.message.toString())
                Toast.makeText(this, "Error sending join proposal.", Toast.LENGTH_SHORT).show()
            }
        ) {
            override fun getParams(): MutableMap<String, String> {
                return hashMapOf(
                    "user_id" to user_id,
                    "team_id" to team_id,
                    "description" to description
                )
            }
        }
        queue.add(stringRequest)
    }

}

