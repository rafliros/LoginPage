package com.example.loginpage.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomePage(onLogout: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Selamat Datang di Home Page 🎉", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(20.dp))

        Text("Anda berhasil login sebagai Admin 👤")

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = onLogout, modifier = Modifier.fillMaxWidth()) {
            Text("Logout")
        }
    }
}
