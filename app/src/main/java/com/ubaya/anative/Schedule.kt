package com.ubaya.anative

import android.health.connect.datatypes.ExerciseRoute.Location


data class Schedule(var name:String,var date: Int,var month: String, var game:String,
                    var team:String, var imageId:Int, var location: String, var Desc: String) {
}