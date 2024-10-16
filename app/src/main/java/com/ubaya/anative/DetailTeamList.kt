package com.ubaya.anative

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.anative.databinding.ActivityDetailTeamListBinding

class DetailTeamList : AppCompatActivity() {
    private lateinit var binding: ActivityDetailTeamListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Inflate layout
        binding = ActivityDetailTeamListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the team name passed from TeamActivity
        val teamName = intent.getStringExtra("team_name")

        binding.txtTeam.text = teamName

        // Initialize the RecyclerView with the MembersAdapter
        val adapter = MembersAdapter(teamName ?: "")
        binding.recMember.layoutManager = LinearLayoutManager(this)
        binding.recMember.adapter = adapter
//        setContentView(R.layout.activity_detail_team_list)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}