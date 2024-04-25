package com.test.search.offers.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.common.navigation.NavigateTo
import com.test.common.network.NetworkStatus
import com.test.core.navigation.NavigationRouter
import com.test.search.offers.domain.usecase.GetDestinationsUseCase
import com.test.search.offers.domain.usecase.GetOffersUseCase
import com.test.search.offers.presentation.uimodel.Destinations
import com.test.search.offers.presentation.uimodel.TicketOffer
import com.test.search.offers.presentation.uimodel.toUI
import kotlinx.coroutines.launch

class OffersViewModel(
    private val router: NavigationRouter<NavigateTo>,
    private val getOffersUseCase: GetOffersUseCase,
    private val getDestinationsUseCase: GetDestinationsUseCase
): ViewModel() {

    private val _ticketsResponse: MutableLiveData<NetworkStatus<List<TicketOffer>>> = MutableLiveData()
    val ticketsResponse: LiveData<NetworkStatus<List<TicketOffer>>> get() = _ticketsResponse

    fun getTickets(){
        viewModelScope.launch {
            try {
                _ticketsResponse.postValue(NetworkStatus.Loading())
                val response = getOffersUseCase.getTickets()
                _ticketsResponse.postValue(NetworkStatus.Success(response.map { it.toUI() }))
            }catch (e: Throwable){
                _ticketsResponse.postValue(NetworkStatus.Error(e.message ?: "Network Error"))
            }
        }
    }

    fun getDestinations(): Destinations = getDestinationsUseCase.getDestinations().toUI()

    fun nextFragment(){
        router.replace(NavigateTo.TicketsFragment)
    }

}