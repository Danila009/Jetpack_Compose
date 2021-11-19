package com.example.jetpackcompose.cells

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.jetpackcompose.Content

@Composable
fun DrovCells(model:Content) {
    Text(text = model.title)
}