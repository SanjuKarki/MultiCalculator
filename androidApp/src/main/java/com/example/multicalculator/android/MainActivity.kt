package com.example.multicalculator.android

import android.media.VolumeShaper.Operation
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
val displayText = remember {mutableStateOf("0")}
    Column(Modifier.background(color = Color.LightGray)){
        Row(){
            CalcDisplay(displayText)
        }
        Row(){
            Column(){
                for (i in 7 downTo 1 step 3){
                    CalcNumericButton(number = 0, display = displayText)
                }
            }
            Column(){
                CalcOperationButton(operation = "+", display = displayText)
                CalcOperationButton(operation = "-", display = displayText)
                CalcOperationButton(operation = "x", display = displayText)
                CalcOperationButton(operation = "/", display = displayText)

            }
        }
    }
}
@Composable
fun CalcRow(display: MutableState<String>, startNum: Int, numButtons: Int) {
 val endNum = startNum + numButtons
    Row(Modifier.padding(0.dp)){
        for (i in startNum downTo endNum) {
            CalcNumericButton(number = i, display = display)
        }
    }
}

@Composable
fun CalcDisplay(display: MutableState<String>) {
Text(text = display.value,
    Modifier
        .height(50.dp)
        .padding(5.dp)
        .fillMaxWidth())
}

@Composable
fun CalcOperationButton(operation: String, display: MutableState<String>) {
 Button(onClick = { /*TODO*/ }, Modifier.padding(4.dp)) {
  Text(text = "")
 }

}

@Composable
fun CalcNumericButton(number: Int, display: MutableState<String>) {
    Button(onClick = {display.value += number.toString()}, Modifier.padding(4.dp)) {
        Text(text = number.toString())
    }
}

@Composable
fun CalcEqualsButton(display: MutableState<String>) {
    Button(onClick = { display.value = "0" }, Modifier.padding(4.dp)) {
    Text(text = "=")
    }
}
