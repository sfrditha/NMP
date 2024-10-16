package com.ubaya.anative

import java.lang.reflect.Member
import java.util.Objects

data class Game(var name:String, var description:String, var imageId:Int,
                val achievements: List<Achievements>, val team: Any) {
}