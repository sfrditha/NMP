package com.ubaya.anative

//class ScheduleAdapter {
//}

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class ScheduleEvent(val date: String, val month: String, val eventName: String, val team: String)

class ScheduleAdapter(private val events: List<ScheduleEvent>) :
    RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>() {

    class ScheduleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDate: TextView = view.findViewById(R.id.tvDate)
        val tvMonth: TextView = view.findViewById(R.id.tvMonth)
        val tvEventName: TextView = view.findViewById(R.id.tvEventName)
        val tvTeam: TextView = view.findViewById(R.id.tvTeam)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.schedule_list, parent, false)
        return ScheduleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        val event = events[position]
        holder.tvDate.text = event.date
        holder.tvMonth.text = event.month
        holder.tvEventName.text = event.eventName
        holder.tvTeam.text = event.team
    }

    override fun getItemCount(): Int {
        return events.size
    }
}
