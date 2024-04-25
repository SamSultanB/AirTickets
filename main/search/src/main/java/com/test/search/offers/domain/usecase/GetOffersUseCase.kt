package com.test.search.offers.domain.usecase

import com.test.search.offers.domain.repository.TicketOffersRepository

class GetOffersUseCase(private val repository: TicketOffersRepository) {

    suspend fun getTickets() = repository.getTickets()

}