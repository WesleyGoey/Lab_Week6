package com.wesley.lab_week6.ui.model.Soal2

import androidx.compose.ui.graphics.vector.ImageVector

data class Workout(
    val name: String,
    val description: String,
    val caloriesBurned: Int,
    val icon: ImageVector,
    val isCompleted: Boolean
)
