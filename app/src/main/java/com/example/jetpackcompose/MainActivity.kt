package com.example.jetpackcompose

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.jetpackcompose.cells.DrovCells
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import kotlin.collections.List

class MainActivity : ComponentActivity() {


    @Preview(showBackground = true)
    @Composable
    fun Preview(){
        Image()
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainViewModel:ButtonCastom = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(ButtonCastom::class.java)
        setContent {
            
            JetpackComposeTheme {
                Column(modifier = Modifier) {
                    repeat(3) {
                        Greeting(name = "Danila")
                    }
                    Image()

                    Column(verticalArrangement = Arrangement.Center){
                        Spacer(
                            modifier = Modifier
                                .height(20.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .fillMaxWidth(fraction = 0.7f)
                                .background(color = Color.Black)
                        )
                    }
                    ButtonOnClickScrollState()
                    ButtonOnClickMyList()
                    CheckboxFun()
                    Switch()

                    mainViewModel.getDate().observe(this@MainActivity, Observer {data->
                      data.forEach{model->
                          //DrovCells(model = model)
                      }
                    })
                }
            }
            mainViewModel.fetchDate()
        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!",
        modifier = Modifier
            .padding(bottom = 8.dp, start = 10.dp)
            .height(30.dp)
            .width(150.dp),
        style = MaterialTheme.typography.h5,
        color = Color.Red)
}

@Composable
fun Image() {

    Row(modifier = Modifier
        .padding(all = 20.dp)) {
        Image(
            painter = painterResource(id = R.drawable.android),
            contentDescription = "Photo",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )

        Column() {
            repeat(2){
                Greeting(name = "?")
            }
        }
    }
}

@Composable
fun ButtonOnClickScrollState(){
    val context = LocalContext.current

    val intent = Intent(context,ScrollState::class.java)

    Button(onClick = {
        context.startActivity(intent)
    },
        Modifier.background(color = Color(R.color.teal_200))
    ) {
     Text(text = "ScrollState")
    }
}

@Composable
fun ButtonOnClickMyList(){
    val context = LocalContext.current

    val intent = Intent(context,MyList::class.java)

    Button(onClick = {
        context.startActivity(intent)
    },
        Modifier.background(color = Color(R.color.purple_200))
    ) {
        Text(text = "MyList")
    }
}

@Composable
fun CheckboxFun(){
    Row() {
        Checkbox(checked = true, onCheckedChange = {

        })
    }
}

@Composable
fun Switch() {
    Switch(checked = false, onCheckedChange = {
        
    })
}
