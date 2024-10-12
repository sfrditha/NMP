package com.ubaya.anative

data class Game(var name:String, var description:String, var imageId:Int,
                val achievements: List<Achievements>) {
}