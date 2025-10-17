package com.wesley.lab_week6.ui.view.Soal1

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wesley.lab_week6.R
import com.wesley.lab_week6.ui.model.Soal1.Product
import com.wesley.lab_week6.ui.model.Soal1.ProductDummyData

@Composable
fun Soal1Card_Product(
    modifier: Modifier,
    product: Product
) {
    Card(
        modifier = modifier
            .width(180.dp)
            .height(130.dp),
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = "Product Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = modifier.height(3.dp))
            Text(
                text = product.name,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color.Black,
            )
            Spacer(modifier = modifier.height(2.dp))
            Text(
                text = "${product.price}$",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color(0xFFD81B60),
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun Soal1Card_ProductPreview() {
    Soal1Card_Product(
        modifier = Modifier,
        product = ProductDummyData.populerMenus[0]
    )
}