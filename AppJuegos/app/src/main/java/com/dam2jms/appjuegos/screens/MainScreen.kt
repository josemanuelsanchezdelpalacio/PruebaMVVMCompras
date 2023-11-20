package com.dam2jms.appjuegos.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dam2jms.appjuegos.navigation.AppScreens

@Composable
fun mainScreen(navController: NavController){
    Column (
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ){
            Button(onClick = { navController.navigate(route = AppScreens.NonesScreen.route) }) {
                Text(text = "Pares y Nones")
            }
            Button(onClick = { navController.navigate(route = AppScreens.NonesScreen.route) }) {
                Text(text = "Piedra, papel y tijeras")
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = { navController.navigate(route = AppScreens.NonesScreen.route) }) {
                Text(text = "Siete y medio")
            }
            Button(onClick = { navController.navigate(route = AppScreens.NonesScreen.route) }) {
                Text(text = "")
            }
        }
    }
}