package com.wesley.lab_week6.ui.view.Soal2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.ScubaDiving
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wesley.lab_week6.ui.model.Soal2.Workout

@Composable
fun Soal2Card_Workout(
    modifier: Modifier = Modifier,
    workout: Workout,
    onToggleAddWorkout: () -> Unit = {},
    showWorkoutButton: Boolean = true
) {
    Card(
        modifier = modifier
            .width(400.dp)
            .background(Color.White)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(8.dp),
        ) {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .background(Color(0xFFF1FAF5), RoundedCornerShape(20.dp))
                    .padding(horizontal = 10.dp, vertical = 8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier.fillMaxSize()
                ) {
                    Box(
                        modifier = modifier
                            .size(72.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFD2EAD7)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = workout.icon,
                            contentDescription = "Yoga Icon",
                            tint = Color(0xFF222222),
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    Spacer(modifier = modifier.width(16.dp))
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = modifier.weight(1f)
                    ) {
                        Text(
                            text = workout.name,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color(0xFF222222)
                        )
                        Spacer(modifier = modifier.height(4.dp))
                        Text(
                            text = "${workout.caloriesBurned} Cals",
                            fontSize = 20.sp,
                            color = Color(0xFF222222)
                        )
                        Spacer(modifier = modifier.height(4.dp))
                        Text(
                            text = workout.description,
                            fontSize = 16.sp,
                            color = Color(0xFF8A8A8A)
                        )
                    }
                    if(showWorkoutButton){
                        IconButton(
                            onClick = onToggleAddWorkout,
                            modifier = modifier
                                .size(36.dp)
                                .clip(CircleShape)
                                .background(
                                    if (workout.isCompleted) Color(0xFFeb4c45)
                                    else Color(0xFF3b85f7)
                                )
                        ) {
                            Icon(
                                imageVector = if (workout.isCompleted) Icons.Default.Remove
                                else Icons.Default.Add,
                                contentDescription = if (workout.isCompleted) "Remove Workout"
                                else "Add Workout",
                                tint = Color.White,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }

                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun Soal2Card_Workout_Preview() {
    Soal2Card_Workout(
        workout = Workout(
            name = "Scuba Diving",
            description = "Cardio",
            caloriesBurned = 100,
            icon = Icons.Default.ScubaDiving,
            isCompleted = false
        )
    )
}