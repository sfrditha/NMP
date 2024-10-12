package com.ubaya.anative

object GameData {
    var gamesData: Array<Game> = arrayOf(
        Game("Valorant", "Game Valo", R.drawable.valo, Achievements.AchievementsData.valorantAchievements),
        Game("PUBG", "Game PUBG", R.drawable.pabji, Achievements.AchievementsData.pubgAchievements),
        Game("Mobile legend", "Game ML", R.drawable.ml, Achievements.AchievementsData.mlbbAchievements)
    )
}