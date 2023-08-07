package com.example.animeworldjetpackcompose.data.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.animeworldjetpackcompose.R
import com.example.animeworldjetpackcompose.ui.navigations.AppScreens

/**
 * @author mvn-toan.nguyen2 on 8/7/23
 **/
enum class BottomBarTabs(
    val route: String, val title: Int, val icon: ImageVector
) {
    HOME(
        route = AppScreens.Home.route,
        title = R.string.main_home,
        icon = Icons.Default.Home
    ),
    FAVORITE(
        route = AppScreens.Favorite.route,
        title = R.string.main_favorite,
        icon = Icons.Default.Favorite
    ),
    SETTING(
        route = AppScreens.Setting.route,
        title = R.string.main_setting,
        icon = Icons.Default.Settings
    )
}
