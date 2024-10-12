package com.ubaya.anative

data class Achievements(val year: Int, val title: String) {
    object AchievementsData{
        val valorantAchievements = listOf(
            Achievements(2022, "Won 10 tournaments"),
            Achievements(2023, "Reached Radiant rank"),
            Achievements(2024, "Completed all agent contracts")
        )

        val mlbbAchievements = listOf(
            Achievements(2022, "Mythical Glory rank"),
            Achievements(2023, "Won National Championship"),
            Achievements(2024, "Top 1 Global Player")
        )

        val pubgAchievements = listOf(
            Achievements(2022, "Top 100 players"),
            Achievements(2023, "Winner Chicken Dinner in 50 games"),
            Achievements(2024, "Conqueror rank")
        )
    }
}