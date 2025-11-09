package com.example.questnavigasitugas_020.view

import com.example.questnavigasitugas_020.Peserta
import com.example.questnavigasitugas_020.dummyPesertaList

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.questnavigasitugas_020.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    onFormulirClicked: () -> Unit = {},
    onBerandaClicked: () -> Unit = {}
) {
    Scaffold(
        containerColor = Color.LightGray,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.titleList),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OutlinedButton(
                    onClick = onBerandaClicked,
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp),
                    shape = RoundedCornerShape(12.dp),
                ) {
                    Text(text = stringResource(id = R.string.btnBackList))
                }

                Button(
                    onClick = onFormulirClicked,
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp),
                    shape = RoundedCornerShape(12.dp),
                ) {
                    Text(text = stringResource(id = R.string.btnDaftarList))
                }
            }
        }
    ) { paddingValues ->

        val pesertaList = remember { dummyPesertaList }

        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

        }
    }
}