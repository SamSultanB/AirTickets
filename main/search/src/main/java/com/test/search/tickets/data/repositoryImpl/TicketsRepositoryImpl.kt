package com.test.search.tickets.data.repositoryImpl

import com.test.search.tickets.data.dto.toModel
import com.test.search.tickets.data.remote.TicketsApi
import com.test.search.tickets.domain.model.TicketModel
import com.test.search.tickets.domain.repository.TicketsRepository

class TicketsRepositoryImpl(private val api: TicketsApi): TicketsRepository {

    override suspend fun getAllTickets(): List<TicketModel> {
        return api.getTickets().tickets.map { it.toModel() }
    }

}