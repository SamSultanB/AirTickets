package com.test.search.chooseCountry.domain.repository

import com.test.search.chooseCountry.domain.model.DestinationsModel
import com.test.search.chooseCountry.domain.model.TicketOfferModel

interface TicketOffersRepository {

    suspend fun getTickets(): List<TicketOfferModel>

    fun getDestinations(): DestinationsModel

}