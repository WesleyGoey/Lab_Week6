package com.wesley.lab_week6.ui.view.Soal1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wesley.lab_week6.R
import com.wesley.lab_week6.ui.viewmodel.Soal1.PandaMartViewModel

@Composable
fun PandamartView(
    modifier: Modifier = Modifier,
    viewModel: PandaMartViewModel = viewModel()
) {
    val searchVegetables by viewModel.searchVegetables.collectAsState()
    val listFeatured by viewModel.listFeatured.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFd9d9d9))
            .padding(24.dp)
    ) {
            Column(
            ) {
                Text(
                    text = "Find Your\nFavourite Vegetables",
                    fontSize = 24.sp,
                    color = Color.Black
                )
            }
        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = searchVegetables,
                onValueChange = {
                    viewModel.searchingVegetables(it)
                },
                placeholder = {
                    Text(
                        "Search for Vegetables",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                leadingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "Search Icon",
                        tint = Color.White
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFbe448e),
                    unfocusedContainerColor = Color(0xFFbe448e),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                ),
                shape = RoundedCornerShape(30.dp),
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Featured Products",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black
            )
            Text(
                text = "View More",
                color = Color(0xFF858585),
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        viewModel.loadFeatured()
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.height(280.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(bottom = 24.dp)
        ) {
            items(listFeatured) { product ->
                Soal1Card_Product(
                    modifier = modifier,
                    product = product
                )
            }
        }
        Spacer(modifier = modifier.height(10.dp))
        Box(){
            Image(
                painter = painterResource(id = R.drawable.salad),
                contentDescription = "Panda Icon",
                modifier = Modifier
                    .size(350.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
            Text(
                text = "20% off on your\nfirst purchase",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 97.dp, top = 115.dp)
            )
            Row(
                modifier = Modifier
                    .padding(start = 90.dp, top = 176.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(24.dp, 6.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(Color(0xFF8BC34A))
                )
                Spacer(modifier = Modifier.width(8.dp))
                repeat(3) {
                    Box(
                        modifier = Modifier
                            .size(6.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color.White)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PandamartPreview() {
    PandamartView()
}