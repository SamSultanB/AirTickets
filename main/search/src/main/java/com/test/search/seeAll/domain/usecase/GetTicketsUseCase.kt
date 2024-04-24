package com.test.search.seeAll.domain.usecase

import com.test.search.seeAll.domain.repository.TicketsRepository

class GetTicketsUseCase(private val repository: TicketsRepository) {

    suspend fun getTickets() = repository.getAllTickets()

}