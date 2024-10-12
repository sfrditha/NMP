package com.ubaya.anative

import java.time.Month
import java.util.Calendar.SEPTEMBER

object ScheduleData {
    var schedulesData: Array<Schedule> = arrayOf(
        Schedule("Valorant The Best!!", 15, "September","Valorant",
            "Team A", R.drawable.valo ),
        Schedule("PUBG Championship", 22, "December", "PUBG", "Team C",
            R.drawable.pabji),
        Schedule("Moblie Legend World Tour Tournament", 25, "November",
            "Mobile Legend", "Team B", R.drawable.ml)
    )
}