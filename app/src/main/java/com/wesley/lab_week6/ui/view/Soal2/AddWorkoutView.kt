package com.wesley.lab_week6.ui.view.Soal2

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.DirectionsWalk
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun AddWorkoutView(
    modifier: Modifier = Modifier,
    onSave: (title: String, type: String, calories: Int, icon: ImageVector) -> Unit,
    onCancel: () -> Unit,
) {
    var inputWorkoutTitle by remember { mutableStateOf("") }
    var inputType by remember { mutableStateOf("") }
    var inputCaloriesBurned by remember { mutableStateOf("") }
    var titleError by remember { mutableStateOf(false) }
    var typeError by remember { mutableStateOf(false) }
    var caloriesError by remember { mutableStateOf(false) }
    var iconError by remember { mutableStateOf(false) }
    val iconList = listOf(
        Icons.Default.LocalFireDepartment,
        Icons.Default.Favorite,
        Icons.Default.Bolt,
        Icons.Default.DirectionsWalk,
        Icons.Default.FitnessCenter
    )
    var selectedIcon by remember { mutableStateOf<ImageVector?>(null) }

    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = Color.White,
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 8.dp,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Add Workout",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            }

            Text(
                text = "Workout Title",
                fontSize = 16.sp,
                color = Color(0xFF97989c)
            )
            OutlinedTextField(
                value = inputWorkoutTitle,
                onValueChange = {
                    inputWorkoutTitle = it
                    titleError = false
                },
                placeholder = { Text("e.g. Morning Run", color = Color(0xFFc7c6cc)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    focusedContainerColor = Color(0xFFf1f1f7),
                    unfocusedContainerColor = Color(0xFFf1f1f7),
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                )
            )
            if (titleError) {
                Text(
                    text = "Please enter a workout title",
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Text(
                text = "Type",
                fontSize = 16.sp,
                color = Color(0xFF97989c)
            )
            OutlinedTextField(
                value = inputType,
                onValueChange = {
                    inputType = it
                    typeError = false
                },
                placeholder = {
                    Text(
                        "e.g. Cardio, Strength",
                        color = Color(0xFFc7c6cc)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    focusedContainerColor = Color(0xFFf1f1f7),
                    unfocusedContainerColor = Color(0xFFf1f1f7),
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                )
            )
            if (typeError) {
                Text(
                    text = "Please enter a workout type",
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Text(
                text = "Calories Burned",
                fontSize = 16.sp,
                color = Color(0xFF97989c)
            )
            OutlinedTextField(
                value = inputCaloriesBurned,
                onValueChange = { newValue ->
                    if (newValue.all { it.isDigit() }) {
                        inputCaloriesBurned = newValue
                        caloriesError = false
                    }
                },
                placeholder = { Text("e.g. 200", color = Color(0xFFc7c6cc)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    focusedContainerColor = Color(0xFFf1f1f7),
                    unfocusedContainerColor = Color(0xFFf1f1f7),
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            if (caloriesError) {
                Text(
                    text = "Please enter calories burned",
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Text(
                text = "Choose Icon",
                fontSize = 16.sp,
                color = Color(0xFF97989c)
            )
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(iconList) { icon ->
                    Box(
                        modifier = Modifier
                            .size(70.dp)
                            .background(
                                if (selectedIcon == icon) {
                                    Color(0xFFd1d1d6)
                                } else {
                                    Color(0xFFf1f2f6)
                                },
                                shape = RoundedCornerShape(16.dp)
                            )
                            .clickable {
                                selectedIcon = icon
                                iconError = false
                            }
                            .padding(8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = icon,
                            contentDescription = null,
                            tint = Color(0xFF8d8e92),
                            modifier = Modifier.size(54.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }

            if (iconError) {
                Text(
                    text = "Please select an icon",
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    titleError = inputWorkoutTitle.isBlank()
                    typeError = inputType.isBlank()
                    caloriesError = inputCaloriesBurned.isBlank()
                    iconError = selectedIcon == null

                    if (!titleError && !typeError && !caloriesError && !iconError) {
                        onSave(
                            inputWorkoutTitle,
                            inputType,
                            inputCaloriesBurned.toInt(),
                            selectedIcon!!
                        )
                    }
                },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(vertical = 4.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8e8e92))
            ) {
                Text("Save Workout", color = Color.White)
            }

            Button(
                onClick = { onCancel() },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(vertical = 4.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFfe383c))
            ) {
                Text("Cancel", color = Color.White)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AddWorkoutPreview() {
    AddWorkoutView(
        onSave = { title: String, type: String, calories: Int, icon: ImageVector -> },
        onCancel = {}
    )
}