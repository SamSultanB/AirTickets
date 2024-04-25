package com.test.search.offers.domain.repository

import com.test.search.offers.domain.model.DestinationsModel
import com.test.search.offers.domain.model.TicketOfferModel

interface TicketOffersRepository {

    suspend fun getTickets(): List<TicketOfferModel>

    fun getDestinations(): DestinationsModel

}