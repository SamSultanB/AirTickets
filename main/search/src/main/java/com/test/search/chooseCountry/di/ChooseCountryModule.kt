package com.test.search.chooseCountry.di

import com.test.common.navigation.NavigateTo
import com.test.core.navigation.NavigationRouter
import com.test.search.chooseCountry.data.local.Preferences
import com.test.search.chooseCountry.data.remote.TicketOffersApi
import com.test.search.chooseCountry.data.repositoryImpl.TicketOffersRepositoryImpl
import com.test.search.chooseCountry.domain.repository.TicketOffersRepository
import com.test.search.chooseCountry.domain.usecase.GetDestinationsUseCase
import com.test.search.chooseCountry.domain.usecase.GetOffersUseCase
import com.test.search.chooseCountry.presentation.ChooseCountryViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val chooseCountryModule = module {

    single { TicketOffersApi() }
    single { Preferences(androidContext()) }
    single<TicketOffersRepository> { TicketOffersRepositoryImpl(get(), get()) }
    single { GetDestinationsUseCase(get()) }
    single { GetOffersUseCase(get()) }
    viewModel{ ChooseCountryViewModel(get<NavigationRouter<NavigateTo>>(), get(), get()) }

}