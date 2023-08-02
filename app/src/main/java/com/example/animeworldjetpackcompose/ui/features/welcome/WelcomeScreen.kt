@file:OptIn(ExperimentalFoundationApi::class)

package com.example.animeworldjetpackcompose.ui.features.welcome

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.animeworldjetpackcompose.ui.component.PageIndicator
import kotlinx.coroutines.delay

/**
 * @author mvn-toan.nguyen2 on 7/28/23
 **/

@Composable
fun WelcomeScreen(onNextScreen: () -> Unit) {
    val viewModel: WelcomeVM = hiltViewModel()
    val itemCount = viewModel.getListUrl().size
    val pagerState = rememberPagerState(initialPage = 0) { itemCount }
    val currentPage = remember {
        mutableIntStateOf(0)
    }

    LaunchedEffect(
        key1 = currentPage.intValue,
    ) {
        delay(1000)
        pagerState.animateScrollToPage(
            currentPage.intValue + 1
        )
        currentPage.intValue = pagerState.currentPage
    }

    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { index ->
        val page = index % itemCount
        val imageRequest = ImageRequest.Builder(LocalContext.current)
            .data(viewModel.getUrlImage(page))
            .size(coil.size.Size.ORIGINAL)
            .build()
        // Our page content
        AsyncImage(
            model = imageRequest,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
    Box(
        Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.align(Alignment.BottomCenter),
        ) {

            PageIndicator(
                numberOfPages = itemCount,
                selectedPage = pagerState.currentPage % itemCount,
                defaultRadius = 15.dp,
                selectedLength = 40.dp,
                space = 10.dp,
                animationDurationInMillis = 1000,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Button Next Screen",
                modifier = Modifier
                    .padding(15.dp)
                    .clickable {
                        onNextScreen.invoke()
                    }
                    .background(Color.Cyan, RoundedCornerShape(25.dp))
                    .padding(vertical = 10.dp, horizontal = 20.dp),
                fontSize = 16.sp
            )
        }
    }
}
