package com.example.animeworldjetpackcompose.ui.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.animeworldjetpackcompose.data.model.BottomBarTabs
import com.example.animeworldjetpackcompose.ui.component.ConstantBottomBar.ALPHA_UNSELECT_ITEM
import com.example.animeworldjetpackcompose.ui.navigations.AppScreens

/**
 * @author mvn-toan.nguyen2 on 8/7/23
 **/


@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarTabs.HOME,
        BottomBarTabs.FAVORITE,
        BottomBarTabs.SETTING,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    NavigationBar {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}


@Composable
fun RowScope.AddItem(
    screen: BottomBarTabs, currentDestination: NavDestination?, navController: NavHostController
) {

    NavigationBarItem(
        label = {
            Text(text = stringResource(id = screen.title))
        },
        icon = {
            Icon(imageVector = screen.icon, contentDescription = "Navigation Icon")
        },
        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
        colors = NavigationBarItemDefaults.colors(
            unselectedIconColor = LocalContentColor.current.copy(
                alpha = ALPHA_UNSELECT_ITEM
            ),
            unselectedTextColor = LocalContentColor.current.copy(
                alpha = ALPHA_UNSELECT_ITEM
            )
        ),
        onClick = {
            navController.navigate(screen.route) {
                navController.graph.find { it.route == AppScreens.Home.route }?.id?.let {
                    popUpTo(it) {
                        saveState = true
                    }
                }
                launchSingleTop = true
                restoreState = true
            }
        })
}

private object ConstantBottomBar {
    const val ALPHA_UNSELECT_ITEM = 0.36f
}
