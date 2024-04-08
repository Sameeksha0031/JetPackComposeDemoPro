package com.example.composepractice

import android.database.Cursor
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.accessibility.AccessibilityViewCommand.ScrollToPositionArguments
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

@Composable
fun HomeScreen(
    textValue : String,
    nameListState: List<String>,
    onValueChange: (String) -> Unit,
    onAddClick:() -> Unit,
    navController: NavController) {
    Log.d("#SAM","inside of HomeScreen function")
    Column(
        Modifier
            .fillMaxSize(),
        Arrangement.Top,
        Alignment.End){
        //var textState by remember { mutableStateOf("")}
        val coroutineScope = rememberCoroutineScope()
        val listState = rememberLazyListState()

        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .weight(1f),
            state = listState,
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally){
            items(nameListState.size){
                LaunchedEffect(nameListState){
                  //  coroutineScope.launch {
                       listState.scrollToItem(nameListState.size - 1)
                  //  }
                }

                Text(text = nameListState[it])
            }
        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(20.dp)) {
            Box(
                Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .weight(5f)
                    .clip(RoundedCornerShape(10.dp))
                    .border(3.dp, Color.Red)
                    .background(Color.Blue)
                    .clickable {
                        Log.d("test", "yrtyrtyerty")
                        navController.navigate(Screen.FirstScreen.route)
                    },
                Alignment.Center) {
                Text("button", color = Color.White)
            }

            Spacer(modifier = Modifier.width(20.dp))

            Box(
                Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .weight(5f)
                    .clip(RoundedCornerShape(10.dp))
                    .border(3.dp, Color.Red)
                    .background(Color.Blue)
                    .clickable {
                        Log.d("test", "yrtyrtyerty")
                        navController
                    },
                Alignment.Center) {
                Text("button2", color = Color.White)
            }
        }
        Spacer(modifier = Modifier.height(30.dp))

        Row(
            Modifier
                .fillMaxWidth()
                .height(150.dp),
            Arrangement.End
        ) {
            TextField( textValue, onValueChange = {
                onValueChange(it)
            },
                Modifier.fillMaxWidth(),
                trailingIcon = {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null,
                        modifier = Modifier.clickable {
                            onAddClick()
                        })
                }
            )
        }
    }
}

