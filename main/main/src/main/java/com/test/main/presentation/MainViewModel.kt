package com.test.main.presentation

import androidx.lifecycle.ViewModel
import com.test.common.navigation.NavigateTo
import com.test.core.navigation.NavigationRouter

class MainViewModel(private val router: NavigationRouter<NavigateTo>): ViewModel() {

    fun nextScreen(){
        router.navigateTo(NavigateTo.ChooseCountry)
    }

}