package com.ubaya.anative

import android.content.Intent
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
import com.ubaya.anative.databinding.ActivityAchievementsBinding
import com.ubaya.anative.databinding.ActivityProposalBinding
import org.json.JSONObject

class ProposalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProposalBinding
    var proposals: ArrayList<Proposal> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val user_id = intent.getIntExtra("user_id", 0)

        // Initialize View Binding
        binding = ActivityProposalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup RecyclerView
        binding.recProposal.layoutManager = LinearLayoutManager(this)
        binding.recProposal.adapter = ProposalAdapter(proposals)

        // Load proposals
        getProposal(user_id.toString())

        // Floating Action Button click listener
        binding.fabAdd.setOnClickListener {
             val intent = Intent(this, ApplyTeamActivity::class.java)
             intent.putExtra("user_id", user_id)
             startActivity(intent)
        }
    }

    fun getProposal(user_id: String) {
        val queue = Volley.newRequestQueue(this)
        val url = "https://ubaya.xyz/native/160722042/get_proposal.php"

        val stringRequest = object : StringRequest(
            Request.Method.POST, url,
            Response.Listener { response ->
                Log.d("apiresult", response)
                val obj = JSONObject(response)

                if (obj.getString("result") == "OK") {
                    val data = obj.getJSONArray("data")
                    val sType = object : TypeToken<List<Proposal>>() {}.type
                    proposals = Gson().fromJson(data.toString(), sType)

                    // Update RecyclerView adapter
                    binding.recProposal.adapter = ProposalAdapter(proposals)
                    binding.recProposal.adapter?.notifyDataSetChanged()
                } else {
                    Toast.makeText(this, "Anda belum mengajukan proposal", Toast.LENGTH_SHORT).show()
                }
            },
            Response.ErrorListener { error ->
                Log.e("apiresult", error.message.toString())
                Toast.makeText(this, "Error fetching proposals.", Toast.LENGTH_SHORT).show()
            }
        ) {
            override fun getParams(): MutableMap<String, String> {
                return hashMapOf("user_id" to user_id)
            }
        }
        queue.add(stringRequest)
    }
}
