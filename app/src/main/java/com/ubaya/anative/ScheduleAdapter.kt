package com.ubaya.anative

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.ubaya.anative.databinding.ScheduleCardBinding

class ScheduleAdapter(val schedules:ArrayList<Schedule>):RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>() {
    class ScheduleViewHolder(val binding: ScheduleCardBinding):
        RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val binding = ScheduleCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return ScheduleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return schedules.size
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        with(holder.binding) {
            txtTeam.text = schedules[position].team
            txtGame.text = schedules[position].game
            txtDate.text = schedules[position].date
            txtMonth.text = schedules[position].month
            txtEventName.text = schedules[position].name
        }
        holder.binding.cardView.setOnClickListener(){
            val intent = Intent(holder.itemView.context, ScheduleDetail::class.java)
            val id_schedule = position + 1;
            intent.putExtra("schedule_index", id_schedule)
            holder.itemView.context.startActivity(intent)
        }

    }
}