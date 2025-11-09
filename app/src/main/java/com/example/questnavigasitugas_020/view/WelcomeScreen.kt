package com.example.questnavigasitugas_020.view


import com.example.questnavigasitugas_020.R
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource


@Composable
fun WelcomeScreen(
    onMasukClicked: () -> Unit = {}
) {
    Scaffold(
        containerColor = colorResource(id = R.color.white)
    ) {
    }
}