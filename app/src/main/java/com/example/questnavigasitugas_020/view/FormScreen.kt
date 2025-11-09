package com.example.questnavigasitugas_020.view


import androidx.compose.material3.*
import androidx.compose.runtime.*


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormScreen(
    onBackClicked: () -> Unit = {},
    onSubmitClicked: (String, String, String, String) -> Unit = { _, _, _, _ -> }
) {
    var namaLengkap by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("") }
    var selectedStatus by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    var isStatusDropdownExpanded by remember { mutableStateOf(false) }
    val statusOptions = listOf("Belum Kawin", "Kawin", "Cerai")
    val genderOptions = listOf("Laki-laki", "Perempuan")

    var showDialog by remember { mutableStateOf(false) }

    var showErrorDialog by remember { mutableStateOf(false) }




}