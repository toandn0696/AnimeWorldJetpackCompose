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
import com.example.animeworldjetpackcompose.ui.features.splash.SplashScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

/**
 * @author mvn-toan.nguyen2 on 7/25/23
 **/
@ExperimentalMaterial3Api
@ExperimentalAnimationApi
@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberAnimatedNavController()
//    val isShouldShowBottomBar =
//        navController.currentBackStackEntryAsState().value?.destination?.route in (BottomBarTabs.values()
//            .map { it.route })
    Scaffold { innerPadding ->
        AnimatedNavHost(
            navController = navController,
            startDestination = AppScreens.Splash.route,
            modifier = modifier.padding(innerPadding)
        ) {
            addSplashScreen(navController)
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