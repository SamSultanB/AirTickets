package com.test.common.navigation

sealed interface NavigateTo{
    data object TicketsSection: NavigateTo
    data object ChooseCountry: NavigateTo
    data object SeeAll: NavigateTo

    data object HotelsSection: NavigateTo
    data object LocationsSection: NavigateTo
    data object SubscribesSection: NavigateTo
    data object ProfileSection: NavigateTo
}