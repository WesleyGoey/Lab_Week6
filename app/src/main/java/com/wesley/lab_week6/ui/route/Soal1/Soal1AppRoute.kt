package com.wesley.lab_week6.ui.route.Soal1

import android.R
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.wesley.lab_week6.ui.view.Soal1.FoodDeliveryView
import com.wesley.lab_week6.ui.view.Soal1.PandamartView
import com.wesley.lab_week6.ui.view.Soal1.Soal1View

enum class AppView(
    val title: String
) {
    Soal1View("Main View"),
    FoodDeliveryView("Food"),
    PandamartView("Vegetables")
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Soal1AppRoute() {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val currentRoute = currentDestination?.route
    val currentView = AppView.entries.find { it.name == currentRoute }

    Scaffold(
        topBar = {
            MyTopAppBar(
                currentView = currentView,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ){ innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = AppView.Soal1View.name
        ) {
            composable(route = AppView.Soal1View.name) {
                Soal1View(navController = navController)
            }
            composable(route = AppView.FoodDeliveryView.name) {
                FoodDeliveryView()
            }
            composable(route = AppView.PandamartView.name) {
                PandamartView()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    currentView: AppView?,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    if(currentView == AppView.PandamartView){
        CenterAlignedTopAppBar(
            title = {
                Text(text = currentView?.title ?: AppView.PandamartView.title)
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color(0xFFBE438E),
                titleContentColor = Color.White
            ),
            modifier = modifier,
            navigationIcon = {
                if (canNavigateBack) {
                    IconButton(onClick = navigateUp) {
                        Icon(
                            imageVector = Icons.Default.ArrowBackIos,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                }
            },
            actions = {
                if (canNavigateBack) {
                    IconButton(onClick = navigateUp) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                }
            }
        )
    }
}