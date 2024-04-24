package com.test.search.chooseCountry.di

import com.test.common.navigation.NavigateTo
import com.test.core.navigation.NavigationRouter
import com.test.search.chooseCountry.data.local.Preferences
import com.test.search.chooseCountry.data.remote.TicketsApi
import com.test.search.chooseCountry.data.repositoryImpl.TicketsRepositoryImpl
import com.test.search.chooseCountry.domain.repository.TicketsRepository
import com.test.search.chooseCountry.domain.usecase.GetDestinationsUseCase
import com.test.search.chooseCountry.domain.usecase.GetTicketsUseCase
import com.test.search.chooseCountry.presentation.ChooseCountryViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val chooseCountryModule = module {

    single { TicketsApi() }
    single { Preferences(androidContext()) }
    single<TicketsRepository> { TicketsRepositoryImpl(get(), get()) }
    single { GetDestinationsUseCase(get()) }
    single { GetTicketsUseCase(get()) }
    viewModel{ ChooseCountryViewModel(get<NavigationRouter<NavigateTo>>(), get(), get()) }

}