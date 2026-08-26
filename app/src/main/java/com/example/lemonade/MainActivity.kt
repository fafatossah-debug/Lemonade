package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
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
        1 -> Triple(
            R.drawable.lemon_tree,
            R.string.lemon_tree,
            R.string.lemon_tree_content_description
        )

        2 -> Triple(R.drawable.lemon_squeeze, R.string.squeeze, R.string.lemon_content_description)
        3 -> Triple(
            R.drawable.lemon_drink,
            R.string.tap_lemon,
            R.string.lemonade_content_description
        )

        else -> Triple(
            R.drawable.lemon_restart,
            R.string.empty_glass,
            R.string.empty_glass_content_description
        )
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = stringResource(contentDescRes),
            modifier = Modifier
                .clickable {
                    when (etapeActuelle) {
                        1 -> {
                            squeezeCount = Random.nextInt(2, 5)
                            etapeActuelle = 2
                        }

                        2 -> {
                            squeezeCount--
                            if (squeezeCount <= 0) {
                                etapeActuelle = 3
                            }
                        }

                        3 -> etapeActuelle = 4
                        4 -> etapeActuelle = 1
                    }
                }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(textRes),
            fontSize = 18.sp
        )
    }
}

