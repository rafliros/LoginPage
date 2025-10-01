package com.example.loginpage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.loginpage.ui.LoginScreen
import com.example.loginpage.ui.HomePage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    // pake rememberSaveable biar state tetap saat konfigurasi (rotate)
    var isLoggedIn by rememberSaveable { mutableStateOf(false) }

    if (isLoggedIn) {
        HomePage(onLogout = { isLoggedIn = false })
    } else {
        LoginScreen(onLoginSuccess = { isLoggedIn = true })
    }
}
