package com.example.dependancyinjection_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dependancyinjection_3.ui.theme.DependancyInjection_3Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DependancyInjection_3Theme {
                NavComponent()
            }
        }
    }
}


@Composable
fun NavComponent(){

    val navController = rememberNavController() // to define the state of the navigation

    NavHost(navController = navController, startDestination = "Screen1")
    {
        composable("Screen1") {
            Character_AnimeUI(navController = navController)
        }


        composable("Screen2") {
            PostUI(navController = navController)
        }


        composable("Screen3/{userId}") { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")?.toIntOrNull() ?: 1
            ProfileUI(navController = navController, userId = userId)
        }

    }
}
