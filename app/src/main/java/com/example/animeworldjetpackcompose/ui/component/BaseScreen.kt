package com.example.animeworldjetpackcompose.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.LifecycleOwner
import com.example.animeworldjetpackcompose.arch.base.BaseViewModel
import com.example.animeworldjetpackcompose.arch.ext.clickableWithoutRipple

/**
 * @author mvn-toan.nguyen2 on 7/28/23
 **/

@Composable
fun BaseScreen(
    viewModel: BaseViewModel? = null,
    background: Color = MaterialTheme.colorScheme.background,
    contentAlignment: Alignment = Alignment.TopStart,
    content: @Composable() BoxScope.() -> Unit,
) {
    val lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
    val focusManager = LocalFocusManager.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .clickableWithoutRipple(
                interactionSource = MutableInteractionSource(),
                onClick = {
                    focusManager.clearFocus()
                }
            )
            .background(background),
        contentAlignment = contentAlignment
    ) {
        content.invoke(this)
    }
}
