@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.composepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepractice.ui.theme.ComposePracticeTheme
import com.google.android.material.bottomappbar.BottomAppBar

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                var textState by remember { mutableStateOf("") }
                var namesListState = remember { mutableListOf<String>() }
              DisplayBox(
                  textState,
                  namesListState,
                  onValuechange = {
                      textState = it
                  },
                  onAddClick = {
                       namesListState.add(textState)
                      textState=""
                  }
              )
            }
        }
    }
}

@Composable
fun DisplayBox(
    textValue : String,
    nameListState: List<String>,
    onValuechange : (String) -> Unit,
    onAddClick:() -> Unit
){
    Column(
        Modifier
            .fillMaxSize(),
        Arrangement.Top){
        //var textState by remember { mutableStateOf("")}

        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)){
            items(nameListState.size){
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
                    onValuechange(it)
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
