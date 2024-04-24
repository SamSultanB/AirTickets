package com.test.search.chooseCountry.domain.repository

import com.test.search.chooseCountry.domain.model.DestinationsModel
import com.test.search.chooseCountry.domain.model.TicketModel

interface TicketsRepository {

    suspend fun getTickets(): List<TicketModel>

    fun getDestinations(): DestinationsModel

}