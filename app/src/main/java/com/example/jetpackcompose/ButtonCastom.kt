package com.example.jetpackcompose

import android.widget.Button
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.unit.dp


@Composable
fun ButtonC() {
    val isLoding = remember {
        mutableStateOf(false)
    }
    
    Button(onClick = {
        isLoding.value = true
    }, Modifier.padding(5.dp),shape = RoundedCornerShape(30.dp)) {
        if (!isLoding.value){
            Text(text = "Click Me")
        }else{
            CircularProgressIndicator(color = Color.White)
        }
    }
}


