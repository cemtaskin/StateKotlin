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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ttposmobile.stateexample.ui.theme.StateExampleTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var viewModel = MainViewModel()

        setContent {
            StateExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun MainScreen (viewModel: MainViewModel){
    val newNameStateContent = viewModel.textFieldState.observeAsState("")

    Column() {
        GreetingList(
                newNameStateContent.value,
                {newName->viewModel.onTextChange(newName)}
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GreetingList(
                 textFieldValue : String,
                 textFieldUpdate: (newName : String)->Unit){


    Column() {
        TextField(value = textFieldValue, onValueChange =textFieldUpdate )
        Button(onClick ={}) {
            Text(textFieldValue)
        }
    }

}



