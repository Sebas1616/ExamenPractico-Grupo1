package com.example.examenparcial2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.examenparcial2.data.local.AppDatabase
import com.example.examenparcial2.data.remote.api.DummyJsonApi
import com.example.examenparcial2.data.remote.api.FrankfurterApi
import com.example.examenparcial2.data.repository.ProductRepository
import com.example.examenparcial2.ui.screen.ProductScreen
import com.example.examenparcial2.ui.theme.ExamenParcial2Theme
import com.example.examenparcial2.ui.viewmodel.ProductViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Inicializar Base de Datos
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "examen_db"
        ).build()

        // 2. Inicializar Retrofit para las 2 APIs
        val dummyApi = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DummyJsonApi::class.java)

        val frankfurterApi = Retrofit.Builder()
            .baseUrl("https://api.frankfurter.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FrankfurterApi::class.java)

        // 3. Crear el Repositorio
        val productRepository = ProductRepository(dummyApi, frankfurterApi, db.productoDao())

        // 4. Factory para el ViewModel
        val viewModelFactory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ProductViewModel(productRepository) as T
            }
        }
        val viewModel = ViewModelProvider(this, viewModelFactory)[ProductViewModel::class.java]

        setContent {
            ExamenParcial2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // 5. Llamar a la pantalla pasando los datos
                    val productos by viewModel.productos.collectAsState()
                    ProductScreen(productos = productos)
                }
            }
        }
    }
}