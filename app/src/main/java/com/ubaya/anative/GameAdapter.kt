package com.ubaya.anative

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.ubaya.anative.databinding.GameCardBinding

class GameAdapter(val games:ArrayList<Game>):RecyclerView.Adapter<GameAdapter.GameViewHolder>() {
    class GameViewHolder(val binding:
                         GameCardBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val binding = GameCardBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return GameViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        with(holder.binding) {
            txtTitle.text = games[position].name
            txtDesc.text = games[position].description

            val url = games[position].img_url
            val builder = Picasso.Builder(holder.itemView.context)
            builder.listener { picasso, uri, exception -> exception.printStackTrace() }
            Picasso.get().load(url).into(holder.binding.imgGame)
        }

        holder.binding.buttonAchievement.setOnClickListener {
            val intent = Intent(holder.itemView.context, AchievementsActivity::class.java)
            val game = games[position]

            // Mengirim data ke AchievementsActivity
            intent.putExtra("game_index", game.id) // Asumsi: id adalah ID unik untuk setiap game
            intent.putExtra("game_image_url", game.img_url) // URL gambar game
            intent.putExtra("game_title", game.name) // Nama game

            holder.itemView.context.startActivity(intent)
        }
        holder.binding.buttonTeams.setOnClickListener{
            val intent = Intent(holder.itemView.context, TeamActivity::class.java)
            val game = games[position]

            // Mengirim data ke AchievementsActivity
            intent.putExtra("game_index", game.id)
            intent.putExtra("game_image_url", game.img_url)
            intent.putExtra("game_title", game.name)

            holder.itemView.context.startActivity(intent)
        }

    }

}