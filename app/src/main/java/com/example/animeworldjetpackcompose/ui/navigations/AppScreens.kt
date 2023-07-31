package com.example.animeworldjetpackcompose.ui.navigations

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

/**
 * @author mvn-toan.nguyen2 on 7/25/23
 **/
sealed class AppScreens(val route: String) {
    enum class ARGUMENT(
        var key: String,
        var routeName: String,
        var type: NavType<*>,
        var defaultValue: Any
    ) {

    }

    object Splash : AppScreens("splash_screen")

    object Welcome : AppScreens("welcome_screen")

    fun routeWithArgsValue(vararg value: Pair<String, Any>): String {
        var routeArg = routeArgs()
        value.forEach {
            routeArg = routeArg.replace("{${it.first}}", it.second.toString())
        }
        return routeArg
    }

    fun namedNavArgs(): List<NamedNavArgument> {
        return ARGUMENT.values().filter { it.routeName == route }.map {
            navArgument(it.key) {
                type = it.type
                defaultValue = it.defaultValue
            }
        }
    }

    fun routeArgs(): String {
        return buildString {
            append(route)
            val args = ARGUMENT.values().filter {
                it.routeName == route
            }
            args.forEachIndexed { index, argument ->
                append(if (index == 0) "?" else "&")
                append("${argument.key}={${argument.key}}")
            }
        }
    }
}
