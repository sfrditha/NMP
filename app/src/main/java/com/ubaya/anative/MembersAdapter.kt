package com.ubaya.anative

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.anative.databinding.DetailTeamCardBinding

class MembersAdapter(val teamName: String) : RecyclerView.Adapter<MembersAdapter.MembersViewHolder>() {

    // ViewHolder class
    class MembersViewHolder(val binding: DetailTeamCardBinding) : RecyclerView.ViewHolder(binding.root)

    // Inflate layout for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MembersViewHolder {
        val binding = DetailTeamCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MembersViewHolder(binding)
    }

    // Return the number of members based on the team
    override fun getItemCount(): Int {
        return when (teamName) {
            "ValorantChamp" -> ValorantMembers.ValorantChamp.size
            "ValorantNoobs" -> ValorantMembers.ValorantNoobs.size
            "ValorantCasuals" -> ValorantMembers.ValorantCasuals.size
            "PUBGChamp" -> PUBGMembers.PUBGChamp.size
            "PUBGNoobs" -> PUBGMembers.PUBGNoobs.size
            "PUBGCasuals" -> PUBGMembers.PUBGCasuals.size
            "MLChamp" -> MLMembers.MLChamp.size
            "MLNoobs" -> MLMembers.MLNoobs.size
            "MLCasuals" -> MLMembers.MLCasuals.size
            else -> 0
        }
    }

    // Bind the data to each item view
    override fun onBindViewHolder(holder: MembersViewHolder, position: Int) {
        when (teamName) {
            "ValorantChamp" -> {

                holder.binding.txtPlayerName.text = ValorantMembers.ValorantChamp[position].name
                holder.binding.txtPlayerRole.text = ValorantMembers.ValorantChamp[position].role
                holder.binding.imgPlayerAvatar.setImageResource(ValorantMembers.ValorantChamp[position].image)
            }
            "ValorantNoobs" -> {
                holder.binding.txtPlayerName.text = ValorantMembers.ValorantNoobs[position].name
                holder.binding.txtPlayerRole.text = ValorantMembers.ValorantNoobs[position].role
                holder.binding.imgPlayerAvatar.setImageResource(ValorantMembers.ValorantNoobs[position].image)
            }
            "ValorantCasuals" -> {
                holder.binding.txtPlayerName.text = ValorantMembers.ValorantCasuals[position].name
                holder.binding.txtPlayerRole.text = ValorantMembers.ValorantCasuals[position].role
                holder.binding.imgPlayerAvatar.setImageResource(ValorantMembers.ValorantCasuals[position].image)
            }
            "PUBGChamp" -> {
                holder.binding.txtPlayerName.text = PUBGMembers.PUBGChamp[position].name
                holder.binding.txtPlayerRole.text = PUBGMembers.PUBGChamp[position].role
                holder.binding.imgPlayerAvatar.setImageResource(PUBGMembers.PUBGChamp[position].image)
            }
            "PUBGNoobs" -> {
                holder.binding.txtPlayerName.text = PUBGMembers.PUBGNoobs[position].name
                holder.binding.txtPlayerRole.text = PUBGMembers.PUBGNoobs[position].role
                holder.binding.imgPlayerAvatar.setImageResource(PUBGMembers.PUBGNoobs[position].image)
            }
            "PUBGCasuals" -> {
                holder.binding.txtPlayerName.text = PUBGMembers.PUBGCasuals[position].name
                holder.binding.txtPlayerRole.text = PUBGMembers.PUBGCasuals[position].role
                holder.binding.imgPlayerAvatar.setImageResource(PUBGMembers.PUBGCasuals[position].image)
            }
            "MLChamp" -> {
                holder.binding.txtPlayerName.text = MLMembers.MLChamp[position].name
                holder.binding.txtPlayerRole.text = MLMembers.MLChamp[position].role
                holder.binding.imgPlayerAvatar.setImageResource(MLMembers.MLChamp[position].image)
            }
            "MLNoobs" -> {
                holder.binding.txtPlayerName.text = MLMembers.MLNoobs[position].name
                holder.binding.txtPlayerRole.text = MLMembers.MLNoobs[position].role
                holder.binding.imgPlayerAvatar.setImageResource(MLMembers.MLNoobs[position].image)
            }
            "MLCasuals" -> {
                holder.binding.txtPlayerName.text = MLMembers.MLCasuals[position].name
                holder.binding.txtPlayerRole.text = MLMembers.MLCasuals[position].role
                holder.binding.imgPlayerAvatar.setImageResource(MLMembers.MLCasuals[position].image)
            }
        }
    }
}
