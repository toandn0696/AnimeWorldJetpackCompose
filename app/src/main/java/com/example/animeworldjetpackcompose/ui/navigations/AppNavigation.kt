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
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.animeworldjetpackcompose.data.model.BottomBarTabs
import com.example.animeworldjetpackcompose.ui.component.BottomBar
import com.example.animeworldjetpackcompose.ui.features.favorite.FavoriteScreen
import com.example.animeworldjetpackcompose.ui.features.home.HomeScreen
import com.example.animeworldjetpackcompose.ui.features.login.method.MethodLoginScreen
import com.example.animeworldjetpackcompose.ui.features.login.register.RegisterScreen
import com.example.animeworldjetpackcompose.ui.features.settings.SettingsScreen
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
    val isShouldShowBottomBar =
        navController.currentBackStackEntryAsState().value?.destination?.route in (BottomBarTabs.values()
            .map { it.route })
    Scaffold(
        bottomBar = {
            if (isShouldShowBottomBar) {
                BottomBar(navController = navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppScreens.Splash.route,
            modifier = modifier.padding(innerPadding)
        ) {
            addSplashScreen(navController)
            addWelcomeScreen(navController)
            addMethodLoginScreen(navController)
            addMethodRegisterScreen(navController)
            addHomeScreen(navController)
            addFavoriteScreen(navController)
            addSettingScreen(navController)
        }
    }
}

private fun NavGraphBuilder.addSplashScreen(navController: NavController) {
    composable(route = AppScreens.Splash.route) {
        SplashScreen {
            navController.navigate(AppScreens.Home.route) {
                popUpTo(route = AppScreens.Splash.route) {
                    inclusive = true
                }
            }
        }
    }
}

private fun NavGraphBuilder.addWelcomeScreen(navController: NavController) {
    composable(route = AppScreens.Welcome.route,
        exitTransition = { defaultExitTransition() },
        enterTransition = { defaultEnterTransition() },
        popEnterTransition = { defaultPopEnterTransition() },
        popExitTransition = { defaultPopExitTransition() }) {
        WelcomeScreen(navController)
    }
}


private fun NavGraphBuilder.addMethodLoginScreen(navController: NavController) {
    composable(route = AppScreens.MethodLogin.route,
        exitTransition = { defaultExitTransition() },
        enterTransition = { defaultEnterTransition() },
        popEnterTransition = { defaultPopEnterTransition() },
        popExitTransition = { defaultPopExitTransition() }) {
        MethodLoginScreen(navController)
    }
}

private fun NavGraphBuilder.addMethodRegisterScreen(navController: NavController) {
    composable(route = AppScreens.Register.route,
        exitTransition = { defaultExitTransition() },
        enterTransition = { defaultEnterTransition() },
        popEnterTransition = { defaultPopEnterTransition() },
        popExitTransition = { defaultPopExitTransition() }) {
        RegisterScreen()
    }
}

private fun NavGraphBuilder.addHomeScreen(navController: NavController) {
    composable(route = AppScreens.Home.route) {
        HomeScreen()
    }
}

private fun NavGraphBuilder.addFavoriteScreen(navController: NavController) {
    composable(route = AppScreens.Favorite.route) {
        FavoriteScreen()
    }
}

private fun NavGraphBuilder.addSettingScreen(navController: NavController) {
    composable(route = AppScreens.Setting.route) {
        SettingsScreen()
    }
}
