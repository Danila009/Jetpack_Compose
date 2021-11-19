package com.example.jetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ButtonCastom():ViewModel() {
    private val mDataList:MutableLiveData<ArrayList<Content>> = MutableLiveData<ArrayList<Content>>().apply { value = ArrayList() }

    fun getDate():LiveData<ArrayList<Content>>{
        return mDataList
    }

    fun fetchDate(){

        val tempArray = ArrayList<Content>()

        tempArray.add(Content(title = "1",image = ""))
        tempArray.add(Content(title = "2",image = ""))
        tempArray.add(Content(title = "3",image = ""))
        tempArray.add(Content(title = "4",image = ""))
        tempArray.add(Content(title = "5",image = ""))
        tempArray.add(Content(title = "6",image = ""))

        mDataList.postValue(tempArray)
    }
}