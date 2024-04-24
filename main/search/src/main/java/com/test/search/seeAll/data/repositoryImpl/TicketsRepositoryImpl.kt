package com.test.search.seeAll.data.repositoryImpl

import com.test.search.seeAll.data.dto.toModel
import com.test.search.seeAll.data.remote.TicketsApi
import com.test.search.seeAll.domain.model.TicketModel
import com.test.search.seeAll.domain.repository.TicketsRepository

class TicketsRepositoryImpl(private val api: TicketsApi): TicketsRepository {

    override suspend fun getAllTickets(): List<TicketModel> {
        return api.getTickets().tickets.map { it.toModel() }
    }

}