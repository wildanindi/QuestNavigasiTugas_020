package com.example.questnavigasitugas_020.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.questnavigasitugas_020.R

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


    Scaffold(
        containerColor = Color(0xFFF5F3F8),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.titleForm),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        }
    ) {
        }
    }
