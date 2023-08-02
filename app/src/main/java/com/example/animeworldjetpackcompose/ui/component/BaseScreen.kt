package com.example.animeworldjetpackcompose.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.LifecycleOwner
import com.example.animeworldjetpackcompose.arch.base.BaseViewModel

/**
 * @author mvn-toan.nguyen2 on 7/28/23
 **/

@Composable
fun BaseScreen(
    viewModel: BaseViewModel? = null,
    background: Color = Color.White,
    contentAlignment: Alignment = Alignment.TopStart,
    content: @Composable() BoxScope.() -> Unit,
    ) {
    val lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(background),
        contentAlignment = contentAlignment
    ) {
        content.invoke(this)
    }
}
