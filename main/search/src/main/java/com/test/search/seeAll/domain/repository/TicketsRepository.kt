package com.test.search.seeAll.domain.repository

import com.test.search.seeAll.domain.model.TicketModel

interface TicketsRepository {

    suspend fun getAllTickets(): List<TicketModel>

}