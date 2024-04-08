package com.example.composepractice

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetUpNavGraph(
    navController: NavHostController
) {
    Log.d("#SAM","inside of SetUpNavGraph")
    NavHost(navController = navController,
        startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            var textState by remember { mutableStateOf("") }
            var namesListState = remember { mutableListOf<String>() }
            HomeScreen(textState,
                namesListState,
                onValueChange = {
                    textState = it
                },
                onAddClick = {
                    namesListState.add(textState)
                    textState=""
                },
                navController)
        }
        composable(route = Screen.FirstScreen.route){
           FirstScreen()
        }
    }
}