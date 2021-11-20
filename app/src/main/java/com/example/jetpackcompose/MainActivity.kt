package com.example.jetpackcompose

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.jetpackcompose.cells.DrovCells
import com.example.jetpackcompose.ui.theme.DarkColors
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import com.example.jetpackcompose.ui.theme.LightColors
import kotlin.collections.List

class MainActivity : ComponentActivity() {


    @Preview(showBackground = true)
    @Composable
    fun Preview(){
        Image()
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            MaterialTheme(
                colors = if(isSystemInDarkTheme()) DarkColors else LightColors
            ) {
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
                        Row {
                         ButtonC()
                         ButtonOnClickMyList()
                         ButtonOnClickScrollState()
                        }
                        Scroll()
                    }
                }
            }
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
fun Scroll() {
    val scrollState = rememberScrollState()
    val context = LocalContext.current

    LaunchedEffect(Unit) { scrollState.animateScrollTo(10000) }
    Column(modifier = Modifier.verticalScroll(scrollState)) {
        repeat(100){

            Box(modifier = Modifier
                .clickable {
                    Toast
                        .makeText(context, "Номер: $it", Toast.LENGTH_SHORT)
                        .show()
                }
                .background(Color.Black)
                .fillMaxWidth()) {
                Text(text = it.toString(),
                    fontSize=it.sp,
                    modifier = Modifier
                        .padding(all = 20.dp)
                        .align(Alignment.Center),
                    color = Color.White,
                    fontWeight = FontWeight.W900,
                    fontFamily = FontFamily.Cursive,
                    fontStyle = FontStyle.Italic,
                    style = TextStyle(
                        shadow = Shadow(Color(0xFFFFFFFF), Offset.Zero,1f)
                    )

                )
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
        modifier =  Modifier
            .padding(5.dp)
            .background(color = Color(R.color.teal_200))
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
        Modifier
            .background(color = Color(R.color.purple_200))
            .padding(5.dp)
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
