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
    ) { paddingValues ->

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Konfirmasi Data") },
                text = {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Text("Nama Lengkap: $namaLengkap")
                        Text("Jenis Kelamin: $selectedGender")
                        Text("Status Perkawinan: $selectedStatus")
                        Text("Alamat: $alamat")
                    }
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            showDialog = false
                            onSubmitClicked(namaLengkap, selectedGender, selectedStatus, alamat)
                        }
                    ) {
                        Text(text = stringResource(id = R.string.submit))
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = { showDialog = false }
                    ) {
                        Text(text = stringResource(id = R.string.batal))
                    }
                }
            )
        }

        if (showErrorDialog) {
            AlertDialog(
                onDismissRequest = { showErrorDialog = false },
                title = { Text("Validasi Gagal") },
                text = { Text("Mohon isi data terlebih dahulu.") },
                confirmButton = {
                    TextButton(
                        onClick = { showErrorDialog = false }
                    ) {
                        Text("OK")
                    }
                }
            )
        }

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState())
        ) {


            Column {
                Text(
                    text = "NAMA LENGKAP",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = namaLengkap,
                    onValueChange = { namaLengkap = it },
                    placeholder = { Text("Isikan nama lengkap") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent
                    ),
                    singleLine = true
                )
            }
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "JENIS KELAMIN",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                genderOptions.forEach { gender ->
                    Row(
                        Modifier
                            .selectable(
                                selected = (selectedGender == gender),
                                onClick = { selectedGender = gender }
                            )
                            .padding(end = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (selectedGender == gender),
                            onClick = { selectedGender = gender }
                        )
                        Text(text = gender)
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "STATUS PERKAWINAN",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))

            ExposedDropdownMenuBox(
                expanded = isStatusDropdownExpanded,
                onExpandedChange = { isStatusDropdownExpanded = !isStatusDropdownExpanded }
            ) {
                OutlinedTextField(
                    value = selectedStatus,
                    onValueChange = {},
                    readOnly = true,
                    placeholder = { Text("Pilih status kawin") },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = isStatusDropdownExpanded)
                    },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent
                    )
                )
                ExposedDropdownMenu(
                    expanded = isStatusDropdownExpanded,
                    onDismissRequest = { isStatusDropdownExpanded = false }
                ) {
                    statusOptions.forEach { status ->
                        DropdownMenuItem(
                            text = { Text(status) },
                            onClick = {
                                selectedStatus = status
                                isStatusDropdownExpanded = false
                            }
                        )
                    }
                }
            }

        }
    }
}