package com.ubaya.anative

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.anative.databinding.ActivityAchievementsBinding
import com.ubaya.anative.databinding.ActivityProposalBinding
import com.ubaya.anative.databinding.DrawerLayoutBinding
import org.json.JSONObject

class ProposalActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityProposalBinding
    private lateinit var binding: DrawerLayoutBinding
    private lateinit var drawerToggle: ActionBarDrawerToggle
    var proposals: ArrayList<Proposal> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Initialize View Binding
        binding = DrawerLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Native"
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        drawerToggle = ActionBarDrawerToggle(this, binding.drawerLayout,
            binding.incProposal.toolbarProposal, R.string.app_name, R.string.app_name)

//        drawerToggle.isDrawerIndicatorEnabled = true
        binding.drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        binding.navView.setNavigationItemSelectedListener{
            when(it.itemId) {
                R.id.itemApplyTeam ->
                    Snackbar.make(this,binding.root, "Apply team", Snackbar.LENGTH_SHORT).show()
                R.id.itemLogOut ->
                    logOut()
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        setSupportActionBar(binding.incProposal.toolbarProposal)


        val user_id = intent.getIntExtra("user_id", 0)



        // Setup RecyclerView
        binding.incProposal.recProposal.layoutManager = LinearLayoutManager(this)
        binding.incProposal.recProposal.adapter = ProposalAdapter(proposals)

        // Load proposals
        getProposal(user_id.toString())

        // Floating Action Button click listener
        binding.incProposal.fabAdd.setOnClickListener {
             val intent = Intent(this, ApplyTeamActivity::class.java)
             intent.putExtra("user_id", user_id)
             startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
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
                    binding.incProposal.recProposal.adapter = ProposalAdapter(proposals)
                    binding.incProposal.recProposal.adapter?.notifyDataSetChanged()
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

    private  fun logOut(){
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }
}
