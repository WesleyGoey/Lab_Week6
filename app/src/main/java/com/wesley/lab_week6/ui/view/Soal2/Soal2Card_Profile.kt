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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wesley.lab_week6.ui.model.Soal2.User
import com.wesley.lab_week6.ui.model.Soal2.UserResource

@Composable
fun Soal2Card_Profile(
    modifier: Modifier = Modifier,
    user: User
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
        ) {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .background(Color(0xFFE8F3FD),  RoundedCornerShape(20.dp))
            ) {
                Card(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFEAF4FB))
                ) {
                    Row(
                        modifier = modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = modifier
                                .size(80.dp)
                                .background(Color(0xFFBFD7F6), shape = RoundedCornerShape(50)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Profile",
                                tint = Color(0xFF222222),
                                modifier = modifier.size(48.dp)
                            )
                        }
                        Spacer(modifier = modifier.width(16.dp))
                        Column(
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "${user.name}, ${user.age}",
                                fontWeight = FontWeight.Bold,
                                fontSize = 22.sp,
                                color = Color(0xFF222222)
                            )
                            Spacer(modifier = modifier.height(4.dp))
                            Text(
                                text = "${user.height} cm / ${user.weight} kg",
                                color = Color(0xFF888888),
                                fontSize = 18.sp
                            )
                            Spacer(modifier = modifier.height(4.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.LocalFireDepartment,
                                    contentDescription = "Fire",
                                    tint = Color(0xFFF2994A),
                                    modifier = modifier.size(22.dp)
                                )
                                Text(
                                    text = " ${user.workoutCount}",
                                    color = Color(0xFFF2994A),
                                    fontSize = 16.sp
                                )
                                Spacer(modifier = modifier.width(16.dp))
                                Icon(
                                    imageVector = Icons.Default.Group,
                                    contentDescription = "Groups",
                                    tint = Color(0xFF2D9CDB),
                                    modifier = modifier.size(22.dp)
                                )
                                Text(
                                    text = " ${user.friendCount}",
                                    color = Color(0xFF2D9CDB),
                                    fontSize = 16.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun Soal2Card_Profile_Preview() {
    Soal2Card_Profile(user = UserResource.user)
}