package com.example.examenparcial2.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examenparcial2.data.local.entity.ProductoEntity
import com.example.examenparcial2.data.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel(private val repository: ProductRepository) : ViewModel() {
    private val _productos = MutableStateFlow<List<ProductoEntity>>(emptyList())
    val productos: StateFlow<List<ProductoEntity>> = _productos

    init {
        fetchProductos()
    }

    private fun fetchProductos() {
        viewModelScope.launch {
            try {
                // Llama al repositorio, fusiona APIs y guarda en Room
                val data = repository.fetchAndSaveProducts()
                _productos.value = data
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
