package com.test.search.chooseCountry.data.repositoryImpl

import com.test.search.chooseCountry.data.dto.toModel
import com.test.search.chooseCountry.data.local.Preferences
import com.test.search.chooseCountry.data.remote.TicketOffersApi
import com.test.search.chooseCountry.domain.model.DestinationsModel
import com.test.search.chooseCountry.domain.model.TicketOfferModel
import com.test.search.chooseCountry.domain.repository.TicketOffersRepository

class TicketOffersRepositoryImpl(private val api: TicketOffersApi, private val preferences: Preferences): TicketOffersRepository {

    override suspend fun getTickets(): List<TicketOfferModel> {
        return api.getTickets().tickets_offers.map { it.toModel() }
    }

    override fun getDestinations(): DestinationsModel {
        return DestinationsModel(preferences.getStart()!!, preferences.getDestination()!!)
    }

}