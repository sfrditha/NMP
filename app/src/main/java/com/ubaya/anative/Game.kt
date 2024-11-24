package com.ubaya.anative

import java.lang.reflect.Member
import java.util.Objects

data class Game(var id:Int, var name:String, var description:String, var img_url:String,
                val achievements: List<Achievements>, val team: Any) {
}