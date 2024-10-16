package com.ubaya.anative

object GameData {
    var gamesData: Array<Game> = arrayOf(
        Game("Valorant", "Game Valo", R.drawable.valo, Achievements.AchievementsData.valorantAchievements,ValorantMembers),
        Game("PUBG", "Game PUBG", R.drawable.pabji, Achievements.AchievementsData.pubgAchievements, PUBGMembers),
        Game("Mobile legend", "Game ML", R.drawable.ml, Achievements.AchievementsData.mlbbAchievements, MLMembers)
    )
}