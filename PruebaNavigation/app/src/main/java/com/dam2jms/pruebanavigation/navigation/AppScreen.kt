package com.dam2jms.pruebanavigation.navigation

sealed class AppScreen (val route: String){
    object FirstScreen: AppScreen(route = "firs_screen")
    object SecondScreen: AppScreen(route = "second_screen")
}
