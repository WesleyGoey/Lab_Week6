package com.wesley.lab_week6.ui.view.Soal2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.wesley.lab_week6.ui.viewmodel.Soal2.HealthyAppViewModel

@Composable
fun ProfileView(
    modifier: Modifier = Modifier,
    viewModel: HealthyAppViewModel = viewModel(),
) {
    val listMyFriends by viewModel.myFriends.collectAsState()
    val listMyWorkouts by viewModel.myWorkouts.collectAsState()
    val currentUser by viewModel.user.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp)
    ) {
        Text(
            text = "Profile",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .padding(top = 30.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Soal2Card_Profile(user = currentUser)
        Spacer(modifier = Modifier.height(15.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Text(
                    text = "Recently Added",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = modifier.height(5.dp))
                if (listMyFriends.isEmpty()) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "No friends yet.", color = Color.Gray, fontSize = 16.sp)
                    }
                } else {
                    LazyRow {
                        items(listMyFriends) { user ->
                            Soal2Card_Friend(
                                user = user,
                                onToggleAddFriend = { viewModel.toggleAddFriend(user) },
                                showAddButton = false
                            )
                            Spacer(modifier = modifier.width(10.dp))
                        }
                    }
                }
                Spacer(modifier = modifier.height(5.dp))
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Text(
                    text = "Recent Workouts",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = modifier.height(5.dp))
                if (listMyWorkouts.isEmpty()) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "No Workouts yet.", color = Color.Gray, fontSize = 16.sp)
                    }
                } else {
                    LazyColumn {
                        items(listMyWorkouts) { workout ->
                            Soal2Card_Workout(
                                workout = workout,
                                onToggleAddWorkout = { viewModel.toggleAddWorkout(workout) },
                                showWorkoutButton = false
                            )
                        }
                    }
                }
                Spacer(modifier = modifier.height(5.dp))
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ProfilePreview() {
    ProfileView()
}