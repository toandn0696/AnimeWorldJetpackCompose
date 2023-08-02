package com.example.animeworldjetpackcompose.ui.navigations

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph

/**
 * @author mvn-toan.nguyen2 on 7/25/23
 **/
@ExperimentalAnimationApi
internal fun defaultEnterTransition(): EnterTransition {
    return fadeIn() + slideInHorizontally(initialOffsetX = { 300 })
}

@ExperimentalAnimationApi
internal fun defaultExitTransition(): ExitTransition {
    return fadeOut() + slideOutHorizontally(targetOffsetX = { -300 })
}

internal val NavDestination.hostNavGraph: NavGraph
    get() = hierarchy.first { it is NavGraph } as NavGraph

@ExperimentalAnimationApi
internal fun defaultPopEnterTransition(): EnterTransition {
    return fadeIn() + slideInHorizontally(initialOffsetX = { -300 })
}

@ExperimentalAnimationApi
internal fun defaultPopExitTransition(): ExitTransition {
    return fadeOut() + slideOutHorizontally(targetOffsetX = { 300 })
}
