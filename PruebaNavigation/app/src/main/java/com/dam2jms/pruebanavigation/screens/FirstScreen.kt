package com.dam2jms.pruebanavigation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dam2jms.pruebanavigation.navigation.AppScreens

@Composable
fun firstScreen(navController: NavController){
    var texto by rememberSaveable { mutableStateOf("") }
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "PRIMERA VENTANA")
        OutlinedTextField(
            value = texto,
            onValueChange = { texto = it },
            label = { Text(text = "Introduce un texto") },
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally)
        )
        Button(onClick = { navController.navigate(route = AppScreens.SecondScreen.route + "/" + texto.toString()) }) {
            Text(text = "Navegar")
        }
    }
}