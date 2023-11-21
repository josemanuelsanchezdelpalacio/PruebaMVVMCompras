package com.dam2jms.juegosapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dam2jms.juegosapp.ui.ViewModelPiedra

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun piedraScreen(navController: NavController, mvvm: ViewModelPiedra) {

    val puntuacion: Int by mvvm.puntuacion.observeAsState(initial = 0)

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "VECES GANADAS: $puntuacion") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Atras")
                    }
                }
            )
        }
    ) { paddingValues ->
        piedraBodyContent(modifier = Modifier.padding(paddingValues), mvvm)
    }
}

@Composable
fun piedraBodyContent(modifier: Modifier, mvvm: ViewModelPiedra) {

    val seleccionJugador: String by mvvm.seleccionJugador.observeAsState(initial = "")

    var mostrarAlertDialog by rememberSaveable { mutableStateOf(false) }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        OutlinedTextField(
            value = seleccionJugador,
            onValueChange = { mvvm.onSeleccionJugador(seleccionJugadorUi = it) },
            label = { Text(text = "Elije entre piedra, papel o tijeras") },
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally)
        )

        if (mostrarAlertDialog) {
            AlertDialog(text = {
                mvvm.resultado.value?.let { Text(text = it) }
            }, onDismissRequest = { mostrarAlertDialog = false }, confirmButton = {
                TextButton(onClick = { mostrarAlertDialog = false }) { Text(text = "OK") }
            })
        }

        Button(
            onClick = {
                //llamo al metodo del viewmodel con la logica
                mvvm.onJuego(context = context)
                mostrarAlertDialog = true
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)

        ) {
            Text(text = "JUGAR")
        }
    }
}