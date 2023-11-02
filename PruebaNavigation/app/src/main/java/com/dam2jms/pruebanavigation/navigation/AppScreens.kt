package com.dam2jms.pruebanavigation.navigation

sealed class AppScreens (val route: String){
    object FirstScreen: AppScreens(route = "firs_screen")
    object SecondScreen: AppScreens(route = "second_screen")
}
