package com.test.search.tickets.domain.repository

import com.test.search.tickets.domain.model.TicketModel

interface TicketsRepository {

    suspend fun getAllTickets(): List<TicketModel>

}