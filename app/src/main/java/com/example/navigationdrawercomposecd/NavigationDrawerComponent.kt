package com.example.navigationdrawercomposecd

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NavigationDrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Here Is Header")
    }
}


@Composable
fun NavigationDrawerBody(
    modifier:Modifier=Modifier,
    drawerItems:List<MenuItem>,
    itemsTextStyle: TextStyle=TextStyle(fontSize = 18.sp),
    onItemClick:(MenuItem)->Unit
) {
    LazyColumn{
        items(drawerItems){
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .clickable {
                        onItemClick(it)
                    }
            ) {
                Icon(imageVector = it.icon, contentDescription = null)
                Spacer(modifier = modifier.width(5.dp))
                Text(text = it.title, style = itemsTextStyle)
            }
        }
    }
}


