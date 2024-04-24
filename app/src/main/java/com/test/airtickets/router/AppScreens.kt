package com.test.airtickets.router

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.test.common.utils.Constants
import com.test.hotels.HotelsFragment
import com.test.locations.LocationsFragment
import com.test.main.presentation.MainFragment
import com.test.profile.ProfileFragment
import com.test.search.chooseCountry.presentation.ChooseCountryFragment
import com.test.search.seeAll.presentation.SeeAllFragment
import com.test.subscribes.SubscribesFragment

object AppScreens {

    //Tickets section screens
    fun mainFragment() = FragmentScreen { MainFragment() }
    fun chooseCountryFragment() = FragmentScreen() { ChooseCountryFragment() }
    fun seeAllFragment() = FragmentScreen { SeeAllFragment() }

    //Other sections
    fun hotelsFragment() = FragmentScreen { HotelsFragment() }
    fun locationFragment() = FragmentScreen { LocationsFragment() }
    fun subscribesFragment() = FragmentScreen { SubscribesFragment() }
    fun profileFragment() = FragmentScreen { ProfileFragment() }


}