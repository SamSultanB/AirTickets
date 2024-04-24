package com.test.search.seeAll.di

import com.test.common.navigation.NavigateTo
import com.test.core.navigation.NavigationRouter
import com.test.search.seeAll.data.remote.TicketsApi
import com.test.search.seeAll.data.repositoryImpl.TicketsRepositoryImpl
import com.test.search.seeAll.domain.repository.TicketsRepository
import com.test.search.seeAll.domain.usecase.GetTicketsUseCase
import com.test.search.seeAll.presentation.SeeAllViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val seeAllModule = module {

    single { TicketsApi() }
    single<TicketsRepository> { TicketsRepositoryImpl(get()) }
    single { GetTicketsUseCase(get()) }
    viewModel{ SeeAllViewModel(get<NavigationRouter<NavigateTo>>(),get()) }

}