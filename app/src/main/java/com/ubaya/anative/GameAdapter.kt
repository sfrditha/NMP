package com.ubaya.anative

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
//        return QuestionData.questions.size
        return GameData.gamesData.size
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
//        holder.binding.imgQuestion.setImageResource(QuestionData.questions[position].imageId)
//        holder.binding.txtQuestionTitle.text = QuestionData.questions[position].question

        holder.binding.imgGame.setImageResource(GameData.gamesData[position].imageId)
        holder.binding.txtTitle.text = GameData.gamesData[position].name
        holder.binding.txtDesc.text = GameData.gamesData[position].description

    }
}