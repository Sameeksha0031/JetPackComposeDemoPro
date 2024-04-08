package com.example.composepractice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composepractice.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("#SAM","onCreate of MainActivity")
        setContent {
            ComposePracticeTheme {
                Log.d("#SAM","inside of ComposePractice theme")
                navController = rememberNavController()
                SetUpNavGraph(navController = navController)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var textName by remember{
        mutableStateOf("Hello")
    }
    var colorText by remember {
        mutableStateOf(0xFFFF00FF)
    }

    Column(modifier = modifier
        .fillMaxWidth()
        .background(Color(0XFFCEAEB1))
        .fillMaxHeight(), verticalArrangement = Arrangement.SpaceEvenly){

        Box(modifier= modifier
            .fillMaxWidth()
            .height(110.dp)
            .background(
                Color(0XFF9EB6C2),
                shape = MaterialTheme.shapes.large
            )
            .clickable {
                textName = "gsdgdfgfs"
                colorText = 0xFFFFFF00
            },
            contentAlignment = Alignment.Center){
            Text(
                text = "Hello $textName",
                modifier = modifier,
                textAlign = TextAlign.Center,
                color = Color(colorText) ,
                fontStyle = FontStyle.Italic,
                fontFamily = FontFamily.Monospace
            )
        }
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }
}
