package com.example.lab_7.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun FormulaZeroApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("races") { UpcomingRacesScreen(navController) }
        composable("drivers") { DriversScreen(navController) }
    }
}

@Composable
fun DriversScreen(x0: NavHostController) {
    TODO("Not yet implemented")
}

@Composable
fun UpcomingRacesScreen(x0: NavHostController) {
    TODO("Not yet implemented")
}