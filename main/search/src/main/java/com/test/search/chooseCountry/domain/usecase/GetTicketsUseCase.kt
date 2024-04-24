package com.test.search.chooseCountry.domain.usecase

import com.test.search.chooseCountry.domain.repository.TicketsRepository

class GetTicketsUseCase(private val repository: TicketsRepository) {

    suspend fun getTickets() = repository.getTickets()

}