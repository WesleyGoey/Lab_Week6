package com.wesley.lab_week6.ui.view.Soal1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.wesley.lab_week6.R
import com.wesley.lab_week6.ui.route.Soal1.AppView
import com.wesley.lab_week6.ui.viewmodel.Soal1.PandaMartViewModel

@Composable
fun Soal1View(
    modifier: Modifier = Modifier,
    viewModel: PandaMartViewModel = viewModel(),
    navController: NavController = rememberNavController()
) {
    val searchCraving by viewModel.searchCraving.collectAsState()
    val selectedButton = viewModel.selectedButton.collectAsState()
    val buttons = listOf("Restaurants", "Deals", "Track Order")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE5E5E5))
            .padding(10.dp)
    ) {
        Spacer(modifier = modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Taste the world\nat your Door\nStep!",
                fontSize = 28.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(8.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.panda_pp),
                contentDescription = "Panda Icon",
                modifier = Modifier.size(56.dp)
            )
        }
        Spacer(modifier = modifier.height(10.dp))
        TextField(
            value = searchCraving,
            onValueChange = {
                viewModel.searchingCraving(it)
            }, placeholder = {
                Text(
                    "What are you craving?", color = Color.White, fontWeight = FontWeight.Bold
                )
            }, trailingIcon = {
                Icon(
                    Icons.Default.Search, contentDescription = "Search Icon", tint = Color.White
                )
            }, colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFbe448e),
                unfocusedContainerColor = Color(0xFFbe448e),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            ), shape = RoundedCornerShape(30.dp), modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            buttons.forEachIndexed { index, category ->
                val isSelected = selectedButton.value == index
                Button(
                    onClick = { viewModel.selectButton(index) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSelected) Color(0xFFc572a6) else Color(0xFFd5c5ce),
                        contentColor = if (isSelected) Color(0xFFfefcfe) else Color(0xFFc26da4)
                    )
                ) {
                    Text(
                        text = category, fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Soal1Card_Main(
                modifier = modifier,
                title = "Food Delivery",
                description = "Delivery from 99 $",
                imageRes = R.drawable.food_delivery,
                onCardClick = {
                    navController.navigate(AppView.FoodDeliveryView.name)
                }
            )
            Spacer(modifier = modifier.width(10.dp))
            Soal1Card_Main(
                modifier = modifier,
                title = "Grocery",
                description = "Get groceries at home",
                imageRes = R.drawable.pandamart,
                onCardClick = {
                    navController.navigate(AppView.PandamartView.name)
                }
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Recommended Available Now!",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(id = R.drawable.pizza),
            contentDescription = "Pizza",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .padding(vertical = 10.dp)
        )
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Soal1Preview() {
    Soal1View(
        modifier = Modifier
    )
}