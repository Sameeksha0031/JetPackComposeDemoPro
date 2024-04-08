package com.example.composepractice

sealed class Screen(val route : String) {
    object  Home : Screen("home_screen")
    object  FirstScreen : Screen("first_screen")
}