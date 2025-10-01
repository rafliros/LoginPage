package com.example.loginpage.ui

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {
    val context = LocalContext.current

    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var loginMessage by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    // Kredensial valid (sesuaikan)
    val validUsername = "admin"
    val validPassword = "admin123"

    // fungsi login (dipanggil dari tombol dan IME done)
    fun doLogin() {
        val u = username.trim()
        val p = password.trim()

        if (u == validUsername && p == validPassword) {
            // berhasil
            Toast.makeText(context, "Login berhasil", Toast.LENGTH_SHORT).show()
            loginMessage = ""
            onLoginSuccess()
        } else {
            loginMessage = "Username atau Password salah!"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Login Page", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    val icon = if (passwordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility
                    Icon(imageVector = icon, contentDescription = "Toggle password")
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { doLogin() }
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { doLogin() }, modifier = Modifier.fillMaxWidth()) {
            Text("Login")
        }

        Spacer(modifier = Modifier.height(12.dp))

        if (loginMessage.isNotEmpty()) {
            Text(text = loginMessage, color = MaterialTheme.colorScheme.error)
        }
    }
}
