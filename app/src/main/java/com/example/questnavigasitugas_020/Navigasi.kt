package com.example.questnavigasitugas_020



import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


enum class Navigasi {
    Welcome,
    Form,
    List
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
){
}