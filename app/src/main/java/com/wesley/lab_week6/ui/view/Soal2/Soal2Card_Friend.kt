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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import com.wesley.lab_week6.ui.model.Soal2.User
import com.wesley.lab_week6.ui.model.Soal2.UserResource
import com.wesley.lab_week6.ui.route.Soal1.AppView
import com.wesley.lab_week6.ui.route.Soal2.AppView2

@Composable
fun Soal2Card_Friend(
    modifier: Modifier = Modifier,
    user: User,
    onToggleAddFriend: () -> Unit = {},
    showAddButton: Boolean = true
) {
    Box(
        modifier = Modifier
            .width(180.dp)
            .height(250.dp)
            .background(Color(0xFFEAF6FB), RoundedCornerShape(32.dp))
            .padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier.fillMaxSize()
        ) {
            Box(
                modifier = modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFBEE3F7)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile",
                    tint = Color(0xFF222222),
                    modifier = modifier.size(80.dp)
                )
            }
            Spacer(modifier = modifier.height(8.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = user.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Spacer(modifier = modifier.height(6.dp))
                Text(
                    text = "${user.age} years old",
                    fontSize = 18.sp,
                    color = Color(0xFF7B7B7B)
                )
            }
            Spacer(modifier = modifier.height(8.dp))
            if (showAddButton){
                Button(
                    onClick = {
                        onToggleAddFriend()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (user.isFriend) {
                            Color(0xFFeb4c45)
                        } else {
                            Color(0xFF3b85f7)
                        },
                        contentColor = Color.White,
                    ),
                    shape = RoundedCornerShape(32.dp),
                    modifier = modifier
                        .fillMaxWidth()
                        .height(40.dp)
                ) {
                    Text(text = if (user.isFriend) "Unfriend" else "Add Friend", fontSize = 20.sp)
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun Soal2Card_Friend_Preview() {
    Soal2Card_Friend(user = UserResource.user)
}