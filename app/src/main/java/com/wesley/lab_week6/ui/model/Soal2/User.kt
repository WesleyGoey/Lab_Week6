package com.wesley.lab_week6.ui.model.Soal2

data class User(
    val name: String,
    val age: Int,
    val height: Int = 0,
    val weight: Int = 0,
    val workoutCount: Int,
    val friendCount: Int,
    val isFriend: Boolean
)
