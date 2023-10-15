package com.example.multicalculator.android

import android.media.VolumeShaper.Operation
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.multicalculator.Greeting

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GreetingView(Greeting().greet())
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}

@Composable
fun CalcView() {

    }
@Composable
fun CalcRow() {

}

@Composable
fun CalcDisplay() {

}

@Composable
fun CalcOperationButton(operation: String, display: MutableState<String>) {
 Button(onClick = { /*TODO*/ }, Modifier.padding(4.dp)) {
  Text(text = "")
 }

}

@Composable
fun CalcNumericButton(number: Int, display: MutableState<String>) {
    Button(onClick = { display.value = "0" }, Modifier.padding(4.dp)) {
        Text(text = "=")
    }
}

@Composable
fun CalcEqualsButton(display: MutableState<String>) {
    Button(onClick = { display.value = "0" }, Modifier.padding(4.dp)) {
    Text(text = "=")
    }
}
