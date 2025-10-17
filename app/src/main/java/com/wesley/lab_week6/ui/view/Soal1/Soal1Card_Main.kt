package com.wesley.lab_week6.ui.view.Soal1

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wesley.lab_week6.R

@Composable
fun Soal1Card_Main(
    modifier: Modifier,
    title: String,
    description: String,
    imageRes: Int,
    onCardClick: () -> Unit = { }
) {
    Card(
        modifier = modifier
            .width(180.dp)
            .height(280.dp)
            .shadow(2.dp, RoundedCornerShape(24.dp))
            .clickable { onCardClick() },
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(top = 24.dp, start = 15.dp, end = 12.dp, bottom = 15.dp),
        ) {
            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = modifier.height(6.dp))
            Row {
                Spacer(modifier = modifier.width(7.dp))
                Text(
                    text = description,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray
                )
            }
            Spacer(modifier = modifier.height(60.dp))
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .align(Alignment.CenterHorizontally)
            )

        }
    }
}

@Composable
@Preview(showBackground = true)
fun Soal1Card_MainPreview() {
    Soal1Card_Main(
        modifier = Modifier,
        title = "Food Delivery",
        description = "Delivery from 99 \$",
        imageRes = R.drawable.food_delivery,
        onCardClick = {}
    )
}