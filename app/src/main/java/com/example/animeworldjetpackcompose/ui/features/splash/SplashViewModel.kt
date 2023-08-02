package com.example.animeworldjetpackcompose.ui.features.splash

import com.example.animeworldjetpackcompose.arch.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author mvn-toan.nguyen2 on 7/31/23
 **/
@HiltViewModel
class SplashViewModel @Inject constructor() : BaseViewModel() {
    companion object {
        private const val TIME_DELAY = 2000L
    }

    internal fun getTimeDelay() = TIME_DELAY
}
