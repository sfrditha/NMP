package com.ubaya.anative

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.anative.databinding.ProposalCardBinding

class ProposalAdapter(val proposals:ArrayList<Proposal>): RecyclerView.Adapter<ProposalAdapter.ProposalViewHolder>() {
    class ProposalViewHolder(val binding: ProposalCardBinding):
        RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProposalViewHolder {
        val binding = ProposalCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return ProposalViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return proposals.size
    }

    override fun onBindViewHolder(holder: ProposalViewHolder, position: Int) {
        with(holder.binding) {
            txtGameTitle.text = proposals[position].game_name;
            txtStatus.text = proposals[position].status;
        }
    }


}