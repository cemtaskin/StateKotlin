package com.ttposmobile.stateexample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ttposmobile.stateexample.ui.theme.StateExampleTheme

var names = mutableListOf<String>("Ali Duru","Aliye Duru")
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen (){
    GreetingList()
}


@Composable
fun GreetingList(){
    var names = remember{
        mutableStateListOf<String>(
            "Ali Duru",
            "Aliye Duru")
    }

    Column() {
        for (name in names){
            Greeting(name = name)
        }
        Button(onClick = {
            names.add("TEST")
            Log.d("TEST","Add New button clicked")
            Log.d("TEST",names.size.toString())
        }) {
            Text("Add New")
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
    StateExampleTheme {
        GreetingList()
    }
}