package com.test.search.chooseCountry.domain.usecase

import com.test.search.chooseCountry.domain.repository.TicketOffersRepository

class GetOffersUseCase(private val repository: TicketOffersRepository) {

    suspend fun getTickets() = repository.getTickets()

}