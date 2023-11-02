package com.dam2jms.pruebanavigation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.dam2jms.pruebanavigation.navigation.AppScreens

@Composable
fun secondScreen(navController: NavController){
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "SEGUNDA VENTANA")
        Button(onClick = { navController.navigate(route = AppScreens.FirstScreen.route) }) {
            Text(text = "Volver a la primera ventana")
        }
    }
}