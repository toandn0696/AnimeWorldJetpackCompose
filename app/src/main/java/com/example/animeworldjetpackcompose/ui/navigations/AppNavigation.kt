@file:OptIn(ExperimentalAnimationApi::class, ExperimentalFoundationApi::class)

package com.example.animeworldjetpackcompose.ui.navigations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.animeworldjetpackcompose.ui.features.splash.SplashScreen
import com.example.animeworldjetpackcompose.ui.features.welcome.WelcomeScreen

/**
 * @author mvn-toan.nguyen2 on 7/25/23
 **/
@ExperimentalMaterial3Api
@ExperimentalAnimationApi
@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
//    val isShouldShowBottomBar =
//        navController.currentBackStackEntryAsState().value?.destination?.route in (BottomBarTabs.values()
//            .map { it.route })
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppScreens.Splash.route,
            modifier = modifier.padding(innerPadding)
        ) {
            addSplashScreen(navController)
            addWelcomeScreen(navController)
        }
    }
}

private fun NavGraphBuilder.addSplashScreen(navController: NavController) {
    composable(route = AppScreens.Splash.route) {
        SplashScreen {
            navController.navigate(AppScreens.Welcome.route) {
                popUpTo(route = AppScreens.Splash.route) {
                    inclusive = true
                }
            }
        }
    }
}

private fun NavGraphBuilder.addWelcomeScreen(navController: NavController) {
    composable(route = AppScreens.Welcome.route) {
        WelcomeScreen() {

        }
    }
}
