package com.example.weatherapp

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.ui.Form
import com.example.weatherapp.ui.MyScreenContent

@ExperimentalAnimationApi
@Composable
fun NavigationBasics() {

    val navController= rememberNavController()

    NavHost(navController = navController, startDestination = "home" ){

        composable(route = "home"){
           MyScreenContent(navController = navController)

        }
        composable( route = "form"){

            Form()
        }
    }

}