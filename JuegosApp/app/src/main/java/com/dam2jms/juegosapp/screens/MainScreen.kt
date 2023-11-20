package com.dam2jms.juegosapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dam2jms.juegosapp.navigation.AppScreens

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
            Button(onClick = { navController.navigate(route = AppScreens.PiedraScreen.route) }) {
                Text(text = "Piedra, papel y tijeras")
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = { navController.navigate(route = AppScreens.SieteScreen.route) }) {
                Text(text = "Siete y medio")
            }
            Button(onClick = { navController.navigate(route = AppScreens.NonesScreen.route) }) {
                Text(text = "")
            }
        }
    }
}


/*
* class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var numero by remember { mutableStateOf(0) }
            var resultado by remember { mutableStateOf("") }
            var isFactorial by remember { mutableStateOf(true) }

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Ingrese un número:",
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(16.dp)
                )

                BasicTextField(
                    value = TextFieldValue(numero.toString()),
                    onValueChange = { value ->
                        numero = value.text.toIntOrNull() ?: 0
                    },
                    modifier = Modifier.padding(16.dp)
                )

                Row(
                    modifier = Modifier.padding(16.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = {
                            isFactorial = true
                            resultado = calculateFactorial(numero).toString()
                        },
                        enabled = numero >= 0
                    ) {
                        Text(text = "Factorial")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(
                        onClick = {
                            isFactorial = false
                            resultado = calculateDivisors(numero).joinToString()
                        },
                        enabled = numero >= 0
                    ) {
                        Text(text = "Divisores")
                    }
                }

                if (resultado.isNotEmpty()) {
                    val operationText = if (isFactorial) "Factorial" else "Divisores"
                    Text(
                        text = "Resultado del $operationText de $numero es:",
                        fontSize = 20.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(16.dp)
                    )
                    Text(
                        text = resultado,
                        fontSize = 18.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }

    private fun calculateFactorial(num: Int): Long {
        if (num <= 1) return 1
        var result: Long = 1
        for (i in 2..num) {
            result *= i
        }
        return result
    }

    private fun calculateDivisors(num: Int): List<Int> {
        val divisors = mutableListOf<Int>()
        for (i in 1..num) {
            if (num % i == 0) {
                divisors.add(i)
            }
        }
        return divisors
    }
}
*/