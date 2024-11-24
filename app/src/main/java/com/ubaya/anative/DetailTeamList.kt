package com.ubaya.anative

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.anative.databinding.ActivityDetailTeamListBinding
import org.json.JSONObject

class DetailTeamList : AppCompatActivity() {
    private lateinit var binding: ActivityDetailTeamListBinding
    var members:ArrayList<Members> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetailTeamListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val teamName = intent.getStringExtra("team_name")
        val teamId = intent.getIntExtra("team_id", 0)

        binding.txtTeam.text = teamName
        fetchMembers(teamId)

    }

    private fun fetchMembers(teamId: Int) {
        val url = "https://ubaya.xyz/native/160722042/get_member.php" // Update URL to match your server
        val queue = Volley.newRequestQueue(this)

        val stringRequest = object : StringRequest(
            Request.Method.POST, url,
            Response.Listener { response ->
                Log.d("apiresult", response)
                val obj = JSONObject(response)

                if (obj.getString("result") == "OK") {
                    val data = obj.getJSONArray("data")
                    val teamsType = object : TypeToken<ArrayList<Members>>() {}.type
                    members = Gson().fromJson(data.toString(), teamsType) as
                            ArrayList<Members>
                    displayTeams(members)
                    Log.d("apiresult", members.toString())
                } else {
                    Toast.makeText(this, "No members found.", Toast.LENGTH_SHORT).show()
                }
            },
            Response.ErrorListener { error ->
                Log.e("apiresult", error.message.toString())
                Toast.makeText(this, "Error fetching members.", Toast.LENGTH_SHORT).show()
            }
        ) {
            override fun getParams(): MutableMap<String, String> {
                return hashMapOf("team_id" to teamId.toString())
            }
        }
        queue.add(stringRequest)
    }

    private fun displayTeams(member: List<Members>) {
        if(member.isNotEmpty()){
            val layoutManager = LinearLayoutManager(this)
            with(binding.recMember) {
                this.layoutManager = layoutManager
                setHasFixedSize(true)
                adapter = MembersAdapter(members)
            }
        }
        else {
            Toast.makeText(this, "Gagal mengambil data", Toast.LENGTH_SHORT).show()
        }
    }
}