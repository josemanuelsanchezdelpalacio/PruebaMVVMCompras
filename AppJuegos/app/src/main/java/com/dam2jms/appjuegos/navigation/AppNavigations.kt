package com.dam2jms.appjuegos.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dam2jms.appjuegos.screens.mainScreen
import com.dam2jms.appjuegos.screens.nonesScreen
import com.dam2jms.appjuegos.screens.piedraScreen
import com.dam2jms.appjuegos.screens.sieteScreen

@Composable
fun appNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.MainScreen.route){
        composable(route = AppScreens.MainScreen.route) { mainScreen(navController) }
        composable(route = AppScreens.NonesScreen.route) { nonesScreen(navController) }
        composable(route = AppScreens.PiedraScreen.route) { piedraScreen(navController) }
        composable(route = AppScreens.SieteScreen.route) { sieteScreen(navController) }
    }
}
