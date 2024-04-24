package com.test.search.chooseCountry.domain.usecase

import com.test.search.chooseCountry.domain.repository.TicketOffersRepository

class GetDestinationsUseCase(private val repository: TicketOffersRepository) {

    fun getDestinations() = repository.getDestinations()

}