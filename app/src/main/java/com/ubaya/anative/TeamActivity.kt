package com.ubaya.anative

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ubaya.anative.databinding.ActivityScheduleBinding
import com.ubaya.anative.databinding.ActivityTeamBinding

class TeamActivity : AppCompatActivity() {
    private lateinit var binding : ActivityTeamBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val index = intent.getIntExtra("game_index",0)
        binding = ActivityTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgTeams.setImageResource(GameData.gamesData[index].imageId);

        if (index==0){
            binding.btnTeamA.text = "ValorantChamp";
            binding.btnTeamB.text = "ValorantNoobs"
            binding.btnTeamC.text = "ValorantCasuals"
        }
        else if(index==1){
            binding.btnTeamA.text = "PUBGChamp";
            binding.btnTeamB.text = "PUBGNoobs"
            binding.btnTeamC.text = "PUBGCasuals"
        }
        else if (index==2){
            binding.btnTeamA.text = "MLChamp";
            binding.btnTeamB.text = "MLNoobs"
            binding.btnTeamC.text = "MLCasuals"
        }

        binding.btnTeamA.setOnClickListener {
            val intent = Intent(this, DetailTeamList::class.java)
            intent.putExtra("team_name", binding.btnTeamA.text.toString())
            startActivity(intent)
        }

        binding.btnTeamB.setOnClickListener {
            val intent = Intent(this, DetailTeamList::class.java)
            intent.putExtra("team_name", binding.btnTeamB.text.toString())
            startActivity(intent)
        }

        binding.btnTeamC.setOnClickListener {
            val intent = Intent(this, DetailTeamList::class.java)
            intent.putExtra("team_name", binding.btnTeamC.text.toString())
            startActivity(intent)
        }

//        setContentView(R.layout.activity_team)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}