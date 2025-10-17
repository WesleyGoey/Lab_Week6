package com.wesley.lab_week6.ui.route.Soal2

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.wesley.lab_week6.ui.view.Soal2.AddWorkoutView
import com.wesley.lab_week6.ui.view.Soal2.FriendsView
import com.wesley.lab_week6.ui.view.Soal2.ProfileView
import com.wesley.lab_week6.ui.view.Soal2.WorkoutsView
import com.wesley.lab_week6.ui.viewmodel.Soal2.HealthyAppViewModel

enum class AppView2(
    val title: String,
    val icon: ImageVector? = null
) {
    ProfileView("Profile", Icons.Filled.Person),
    WorkoutsView("Workouts", Icons.Filled.LocalFireDepartment),
    FriendsView("Friends", Icons.Filled.Group),
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Soal2AppRoute() {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val currentRoute = currentDestination?.route
    val currentView = AppView2.entries.find { it.name == currentRoute }

    val viewModel: HealthyAppViewModel = viewModel()

    val bottomNavItem = listOf(
        BottomNavItem(AppView2.ProfileView, "Profile"),
        BottomNavItem(AppView2.WorkoutsView, "Workouts"),
        BottomNavItem(AppView2.FriendsView, "Friends")
    )

    Scaffold(
        bottomBar = {
            MyBottomNavigationBar(
                navController = navController,
                currentDestination = currentDestination,
                items = bottomNavItem
            )
        }
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = AppView2.ProfileView.name
        ) {
            composable(route = AppView2.ProfileView.name) {
                ProfileView(viewModel = viewModel)
            }
            composable(route = AppView2.WorkoutsView.name) {
                WorkoutsView(viewModel = viewModel)
            }
            composable(route = AppView2.FriendsView.name) {
                FriendsView(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun MyBottomNavigationBar(
    navController: NavHostController,
    currentDestination: NavDestination?,
    items: List<BottomNavItem>
) {
    if (items.any { it.view.name == currentDestination?.route }) {
        NavigationBar {
            items.forEach { item ->
                NavigationBarItem(
                    icon = { Icon(item.view.icon!!, contentDescription = item.label) },
                    label = { Text(item.label) },
                    selected = currentDestination?.hierarchy?.any { it.route == item.view.name } == true,
                    onClick = {
                        navController.navigate(item.view.name) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}

data class BottomNavItem(
    val view: AppView2,
    val label: String
)