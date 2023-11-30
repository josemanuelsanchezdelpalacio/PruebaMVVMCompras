package com.dam2jms.pruebamvvmcompras

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dam2jms.pruebamvvmcompras.ui.theme.PruebaMVVMComprasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PruebaMVVMComprasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainActivityBodyContent(MainViewModel())
                }
            }
        }
    }
}

@Composable
fun MainActivityBodyContent(mainViewModel: MainViewModel) {

    val mainUiState by mainViewModel.uiState.collectAsState()

    //viewmodel normal
    //val producto by mainViewModel.producto.observeAsState(initial = "")
    //sin viewmodel
    var suma: Int by rememberSaveable { mutableStateOf(0) }

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = mainUiState.producto,
            onValueChange = { mainViewModel.onProductoChange(it) },
            label = { Text(text = "Elije producto") },
            modifier = Modifier.width(150.dp)
        )
        Button(
            onClick = { suma-- }
        ) {
            Text(text = "-")
        }
        OutlinedTextField(value = suma.toString(), onValueChange = {suma = it.toInt()}, modifier = Modifier.width(50.dp))
        Button(
            onClick = { suma++ }
        ) {
            Text(text = "+")
        }
    }
}
