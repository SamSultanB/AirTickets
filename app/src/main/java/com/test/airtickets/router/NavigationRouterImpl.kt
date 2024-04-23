package com.test.airtickets.router

import com.github.terrakok.cicerone.Router
import com.test.common.navigation.NavigateTo
import com.test.core.navigation.NavigationRouter

class NavigationRouterImpl(private val router: Router): NavigationRouter<NavigateTo> {

    override fun navigateTo(action: NavigateTo) {
        when(action){
            is NavigateTo.TicketsSection -> router.navigateTo(AppScreens.mainFragment())
            is NavigateTo.ChooseCountry -> router.navigateTo(AppScreens.chooseCountryFragment())
            is NavigateTo.SeeAll -> router.navigateTo(AppScreens.seeAllFragment())

            is NavigateTo.HotelsSection -> router.navigateTo(AppScreens.hotelsFragment())
            is NavigateTo.LocationsSection -> router.navigateTo(AppScreens.mainFragment())
            is NavigateTo.SubscribesSection -> router.navigateTo(AppScreens.subscribesFragment())
            is NavigateTo.ProfileSection -> router.navigateTo(AppScreens.profileFragment())
        }
    }

    override fun pop() {
        router.exit()
    }

    override fun replace(action: NavigateTo) {
        when(action){
            is NavigateTo.TicketsSection -> router.navigateTo(AppScreens.mainFragment())
            is NavigateTo.ChooseCountry -> router.navigateTo(AppScreens.chooseCountryFragment())
            is NavigateTo.SeeAll -> router.navigateTo(AppScreens.seeAllFragment())

            is NavigateTo.HotelsSection -> router.navigateTo(AppScreens.hotelsFragment())
            is NavigateTo.LocationsSection -> router.navigateTo(AppScreens.mainFragment())
            is NavigateTo.SubscribesSection -> router.navigateTo(AppScreens.subscribesFragment())
            is NavigateTo.ProfileSection -> router.navigateTo(AppScreens.profileFragment())
        }
    }

}