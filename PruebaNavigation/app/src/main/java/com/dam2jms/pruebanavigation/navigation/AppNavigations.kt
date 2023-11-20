package com.dam2jms.pruebanavigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dam2jms.pruebanavigation.screens.firstScreen
import com.dam2jms.pruebanavigation.screens.secondScreen

@Composable
fun appNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.FirstScreen.route){
        composable(route = AppScreens.FirstScreen.route) { firstScreen(navController) }
        composable(route = AppScreens.SecondScreen.route + "/{texto}",
            //paso lista de argumentos. /{text} type = NavType.StringType para indicar que es de tipo String
            arguments = listOf(navArgument(name = "texto") {type = NavType.StringType})
            ) { secondScreen(navController, it.arguments?.getString("texto")) }
    }
}
