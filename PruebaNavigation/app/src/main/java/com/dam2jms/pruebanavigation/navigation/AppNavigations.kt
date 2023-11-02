package com.dam2jms.pruebanavigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dam2jms.pruebanavigation.screens.firstScreen
import com.dam2jms.pruebanavigation.screens.secondScreen

@Composable
fun appNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.FirstScreen.route){
        composable(route = AppScreens.FirstScreen.route) { firstScreen(navController) }
        composable(route = AppScreens.SecondScreen.route) { secondScreen(navController) }
    }
}
