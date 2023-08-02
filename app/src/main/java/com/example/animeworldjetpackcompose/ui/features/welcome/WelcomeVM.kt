package com.example.animeworldjetpackcompose.ui.features.welcome

import com.example.animeworldjetpackcompose.arch.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author mvn-toan.nguyen2 on 8/1/23
 **/
@HiltViewModel
class WelcomeVM @Inject constructor() : BaseViewModel() {
    private val listUrl =
        mutableListOf(
            "https://m.media-amazon.com/images/I/A1CB1w6rvKL.jpg",
            "https://images.hdqwalls.com/wallpapers/thumb/anime-ninja-4k-lo.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFRQ4xUB9FwtYEnAjr7nNfVnslyvBsoDVgmw&usqp=CAU"
        )


    internal fun getUrlImage(pos: Int) = listUrl[pos]

    internal fun getListUrl() = listUrl
}
