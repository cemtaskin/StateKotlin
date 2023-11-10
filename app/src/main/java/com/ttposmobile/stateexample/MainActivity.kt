package com.ttposmobile.stateexample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
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
    var names = remember{
        mutableStateListOf<String>(
            "Ali Duru",
            "Aliye Duru")
    }
    var textFieldValue = remember {
        mutableStateOf("")
    }
    Column() {
        GreetingList(
                names,
                {
                    names.add(textFieldValue.value)
                    textFieldValue.value=""
                },
                textFieldValue.value,
                {newName->textFieldValue.value=newName}
        )
        NamesCount(names = names)
    }
    
    
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GreetingList(names: MutableList<String>,
                 buttonClick : ()-> Unit ,
                 textFieldValue : String,
                 textFieldUpdate: (newName : String)->Unit){


    Column() {
        for (name in names){
            Greeting(name = name)
        }
        TextField(value = textFieldValue, onValueChange =textFieldUpdate )
        Button(onClick =buttonClick) {
            Text("Add New")
        }
    }

}
@Composable
fun NamesCount(names: MutableList<String>){
    Text(names.size.toString())
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
        
    }
}