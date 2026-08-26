package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeApp() {

    var etapeActuelle by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }

    val (imageRes, textRes, contentDescRes) = when (etapeActuelle) {
        1 -> Triple(R.drawable.lemon_tree, R.string.lemon_tree, R.string.lemon_tree_content_description)
        2 -> Triple(R.drawable.lemon_squeeze, R.string.squeeze, R.string.lemon_content_description)
        3 -> Triple(R.drawable.lemon_drink, R.string.tap_lemon, R.string.lemonade_content_description)
        else -> Triple(R.drawable.lemon_restart, R.string.empty_glass, R.string.empty_glass_content_description)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
}

