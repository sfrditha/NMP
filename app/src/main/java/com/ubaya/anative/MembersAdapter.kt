package com.ubaya.anative

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.ubaya.anative.databinding.DetailTeamCardBinding

class MembersAdapter(val members:ArrayList<Members>) : RecyclerView.Adapter<MembersAdapter.MembersViewHolder>() {

    // ViewHolder class
    class MembersViewHolder(val binding: DetailTeamCardBinding) : RecyclerView.ViewHolder(binding.root)

    // Inflate layout for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MembersViewHolder {
        val binding = DetailTeamCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MembersViewHolder(binding)
    }

    // Return the number of members based on the team
    override fun getItemCount(): Int {
        return members.size
    }

    // Bind the data to each item view
    override fun onBindViewHolder(holder: MembersViewHolder, position: Int) {

        with(holder.binding) {
            txtPlayerName.text = members[position].name
            txtPlayerRole.text = members[position].role
            val url = members[position].image
            val builder = Picasso.Builder(holder.itemView.context)
            builder.listener { picasso, uri, exception -> exception.printStackTrace() }
            Picasso.get().load(url).into(holder.binding.imgPlayerAvatar)

        }
    }
}
