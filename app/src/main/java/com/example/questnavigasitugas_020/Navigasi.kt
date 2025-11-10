package com.example.questnavigasitugas_020


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.questnavigasitugas_020.view.FormScreen
import com.example.questnavigasitugas_020.view.ListScreen
import com.example.questnavigasitugas_020.view.WelcomeScreen

enum class Navigasi {
    Welcome,
    Form,
    List
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
){
    Scaffold { isiRuang->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Welcome.name, // Layar awal
            modifier = Modifier.padding(paddingValues = isiRuang)
        ){

            composable(route = Navigasi.Welcome.name) {
                WelcomeScreen(

                    onMasukClicked = {
                        navController.navigate(Navigasi.List.name)
                    }
                )
            }

            composable(route = Navigasi.Form.name){
                FormScreen (
                    onSubmitClicked = { _, _, _, _ ->
                    },
                    onBackClicked = {
                        navController.navigate(Navigasi.List.name)                    }
                )
            }

            composable(route = Navigasi.List.name){
                ListScreen (
                    onBerandaClicked = {
                        popBackToWelcome(navController)
                    },
                    onFormulirClicked = {
                        navController.navigate(Navigasi.Form.name)
                    }
                )
            }
        }
    }
}

private fun popBackToWelcome(
    navController: NavHostController
){
    navController.popBackStack(route = Navigasi.Welcome.name, inclusive = false)
}