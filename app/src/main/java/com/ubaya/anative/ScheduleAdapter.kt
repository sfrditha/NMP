package com.ubaya.anative

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.anative.databinding.ScheduleCardBinding

class ScheduleAdapter():RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>() {
    class ScheduleViewHolder(val binding: ScheduleCardBinding):
        RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val binding = ScheduleCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return ScheduleViewHolder(binding)
    }

    override fun getItemCount(): Int {
//        return QuestionData.questions.size
        return ScheduleData.schedulesData.size
        //tes
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.binding.txtEventName.text = ScheduleData.schedulesData[position].name;
        holder.binding.txtDate.text = ScheduleData.schedulesData[position].date.toString();
        holder.binding.txtGame.text = ScheduleData.schedulesData[position].game;
        holder.binding.txtTeam.text = ScheduleData.schedulesData[position].team;
        holder.binding.txtMonth.text = ScheduleData.schedulesData[position].month;

    }
}