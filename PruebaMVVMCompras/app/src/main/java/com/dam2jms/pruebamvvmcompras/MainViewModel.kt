package com.dam2jms.pruebamvvmcompras

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel: ViewModel() {

    /*private val _producto = MutableLiveData("")
    val producto: LiveData<String> = _producto

    fun onProductoChange(producto: String) {
        _producto.value = producto
    }*/


    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    fun onProductoChange(producto: String) {
        _uiState.update {
            currentState -> currentState.copy(producto = producto)
        }
    }

}