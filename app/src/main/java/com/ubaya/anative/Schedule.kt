package com.ubaya.anative

import android.health.connect.datatypes.ExerciseRoute.Location


data class Schedule(var id:Int,var name:String,var date: String,var month: String, var game:String,
                    var team:String, var img_url:String, var location: String, var description: String) {
}