package com.example.androidiosexample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidiosexample.ui.theme.AndroidIosExampleTheme
import com.example.shared.BaseClass
import com.example.shared.presentation.LoginForm

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidIosExampleTheme {
                Scaffold { paddingValues ->
                    LoginForm(
                        modifier = Modifier.padding(paddingValues),
                    )
                }
            }
        }
        val baseClass = BaseClass().printMyName()
        Log.d("MainActivity", "baseClass: $baseClass")
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
    AndroidIosExampleTheme {
        Greeting("Android")
    }
}