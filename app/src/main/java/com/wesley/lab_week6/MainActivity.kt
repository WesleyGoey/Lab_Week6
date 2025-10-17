package com.wesley.lab_week6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.wesley.lab_week6.ui.route.Soal1.Soal1AppRoute
import com.wesley.lab_week6.ui.route.Soal2.Soal2AppRoute
import com.wesley.lab_week6.ui.theme.Lab_Week6Theme
import com.wesley.lab_week6.ui.view.Soal1.Soal1View

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab_Week6Theme {
                Soal1AppRoute()
//                Soal2AppRoute()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab_Week6Theme {
        Greeting("Android")
    }
}