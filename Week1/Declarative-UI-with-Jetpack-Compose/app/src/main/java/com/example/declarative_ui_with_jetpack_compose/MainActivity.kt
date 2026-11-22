package com.example.declarative_ui_with_jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.declarative_ui_with_jetpack_compose.day1.CounterScreen
import com.example.declarative_ui_with_jetpack_compose.day1.ProfileScreen
import com.example.declarative_ui_with_jetpack_compose.day2.RecompositionDemo
import com.example.declarative_ui_with_jetpack_compose.ui.theme.DeclarativeUIwithJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DeclarativeUIwithJetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Day1Screen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Day1Screen(modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        ProfileScreen(name = "Chai Lover", role = "Android Developer", followers = 120, following = 48)
        CounterScreen()
        RecompositionDemo()
    }
}

@Preview(showBackground = true)
@Composable
fun Day1ScreenPreview() {
    DeclarativeUIwithJetpackComposeTheme {
        Day1Screen()
    }
}
