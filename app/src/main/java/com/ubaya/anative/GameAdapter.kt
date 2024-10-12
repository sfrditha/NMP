package com.ubaya.anative

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.anative.databinding.GameCardBinding

class GameAdapter():RecyclerView.Adapter<GameAdapter.GameViewHolder>() {
    class GameViewHolder(val binding:
                         GameCardBinding): RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val binding = GameCardBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return GameViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return GameData.gamesData.size
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {

        holder.binding.imgGame.setImageResource(GameData.gamesData[position].imageId)
        holder.binding.txtTitle.text = GameData.gamesData[position].name
        holder.binding.txtDesc.text = GameData.gamesData[position].description

        holder.binding.buttonAchievement.setOnClickListener{
            val intent = Intent(holder.itemView.context, AchievementsActivity::class.java)
            intent.putExtra("game_index", position)
            holder.itemView.context.startActivity(intent)
        }

    }

}