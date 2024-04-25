package com.test.search.offers.domain.usecase

import com.test.search.offers.domain.repository.TicketOffersRepository

class GetDestinationsUseCase(private val repository: TicketOffersRepository) {

    fun getDestinations() = repository.getDestinations()

}