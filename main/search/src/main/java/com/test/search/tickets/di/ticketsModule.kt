package com.test.search.tickets.di

import com.test.common.navigation.NavigateTo
import com.test.core.navigation.NavigationRouter
import com.test.search.tickets.data.remote.TicketsApi
import com.test.search.tickets.data.repositoryImpl.TicketsRepositoryImpl
import com.test.search.tickets.domain.repository.TicketsRepository
import com.test.search.tickets.domain.usecase.GetTicketsUseCase
import com.test.search.tickets.presentation.TicketsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ticketsModule = module {

    single { TicketsApi() }
    single<TicketsRepository> { TicketsRepositoryImpl(get()) }
    single { GetTicketsUseCase(get()) }
    viewModel{ TicketsViewModel(get<NavigationRouter<NavigateTo>>(),get()) }

}