package com.wesley.lab_week6.ui.view.Soal2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.wesley.lab_week6.ui.viewmodel.Soal2.HealthyAppViewModel

@Composable
fun WorkoutsView(
    modifier: Modifier = Modifier,
    viewModel: HealthyAppViewModel = viewModel(),
) {
    val showDialog = rememberSaveable { mutableStateOf(false) }
    val listWorkouts by viewModel.workouts.collectAsState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp)
    ) {
        Column {
            Text(
                text = "Workouts",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 30.dp, bottom = 20.dp)
            )
            if (listWorkouts.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No workouts Found.",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            } else {
                LazyColumn {
                    items(listWorkouts) { workout ->
                        Soal2Card_Workout(
                            workout = workout,
                            onToggleAddWorkout = { viewModel.toggleAddWorkout(workout) }
                        )
                    }
                }
            }
        }
        FloatingActionButton(
            onClick = { showDialog.value = true },
            shape = CircleShape,
            containerColor = Color(0xFF2196F3),
            contentColor = Color.White,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Icon(
                Icons.Default.Add,
                contentDescription = "Add Workout",
                modifier = Modifier.size(35.dp)
            )
        }
        if (showDialog.value) {
            Dialog(
                onDismissRequest = { showDialog.value = false }
            ) {
                AddWorkoutView(
                    onSave = { title, type, calories, icon ->
                        viewModel.saveWorkoutForm(title, type, calories, icon)
                        showDialog.value = false
                    },
                    onCancel = {
                        showDialog.value = false
                    }
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun WorkoutsPreview() {
    WorkoutsView()
}
