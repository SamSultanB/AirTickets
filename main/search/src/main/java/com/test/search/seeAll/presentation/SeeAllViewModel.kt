package com.test.search.seeAll.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.common.navigation.NavigateTo
import com.test.common.network.NetworkStatus
import com.test.core.navigation.NavigationRouter
import com.test.search.seeAll.domain.usecase.GetTicketsUseCase
import com.test.search.seeAll.presentation.uimodel.Ticket
import com.test.search.seeAll.presentation.uimodel.toUI
import kotlinx.coroutines.launch

class SeeAllViewModel(
    private val router: NavigationRouter<NavigateTo>,
    private val getTicketsUseCase: GetTicketsUseCase
): ViewModel() {

    private val _ticketsResponse: MutableLiveData<NetworkStatus<List<Ticket>>> = MutableLiveData()
    val ticketsResponse: LiveData<NetworkStatus<List<Ticket>>> get() = _ticketsResponse

    fun getTickets(){
        viewModelScope.launch {
            try {
                _ticketsResponse.postValue(NetworkStatus.Loading())
                val response = getTicketsUseCase.getTickets()
                _ticketsResponse.postValue(NetworkStatus.Success(response.map { it.toUI() }))
            }catch (e: Throwable){
                _ticketsResponse.postValue(NetworkStatus.Error(e.message ?: "Network Error"))
            }
        }
    }

    fun navigateBack(){
        router.pop()
    }

}