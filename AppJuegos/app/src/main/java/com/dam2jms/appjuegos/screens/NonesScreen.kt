package com.dam2jms.appjuegos.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dam2jms.appjuegos.navigation.AppScreens

@Composable
fun nonesScreen(navController: NavController) {

    var nonesJugador by rememberSaveable { mutableStateOf("") }
    var numeroJugador by rememberSaveable { mutableStateOf("") }
    var nonesPC by rememberSaveable { mutableStateOf("") }
    var numeroPC = (1..5).random()
    var mostrarAlertDialog by rememberSaveable { mutableStateOf(false) }

    var suma: Int
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = nonesJugador,
            onValueChange = { nonesJugador = it },
            label = { Text(text = "Elije entre pares o nones") },
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally)
        )

        OutlinedTextField(
            value = numeroJugador,
            onValueChange = { numeroJugador = it },
            label = { Text(text = "Elije la tirada entre 1 y 5") },
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally)
        )

        Button(
            onClick = {
                suma = numeroJugador.toInt() + numeroPC

                if (nonesJugador.equals("pares")) {
                    nonesPC = "nones"
                    if(suma % 2 == 0){
                        Toast.makeText(context, "La suma es $suma. Gana pares", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context, "La suma es $suma. Gana nones", Toast.LENGTH_SHORT).show()
                    }
                } else if (nonesJugador.equals("nones")) {
                    nonesPC = "pares"
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "JUGAR")
        }
    }
}