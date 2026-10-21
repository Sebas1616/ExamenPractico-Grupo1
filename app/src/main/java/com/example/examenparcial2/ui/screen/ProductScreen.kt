package com.example.examenparcial2.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.examenparcial2.data.local.entity.ProductoEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreen(productos: List<ProductoEntity>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Productos (BOB) - Grupo 1") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        }
    ) { padding ->
        LazyColumn(
            contentPadding = padding,
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp)
        ) {
            items(productos) { producto ->
                Card(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = producto.title, style = MaterialTheme.typography.titleMedium)
                        Text(text = "Categoría: ${producto.category}", style = MaterialTheme.typography.bodyMedium)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Precio final: ${String.format("%.2f", producto.priceBOB)} Bs.",
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "(Precio original: $${producto.priceUSD})", 
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}
