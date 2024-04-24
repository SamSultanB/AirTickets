package com.test.search.chooseCountry.data.repositoryImpl

import com.test.search.chooseCountry.data.dto.toModel
import com.test.search.chooseCountry.data.local.Preferences
import com.test.search.chooseCountry.data.remote.TicketsApi
import com.test.search.chooseCountry.domain.model.DestinationsModel
import com.test.search.chooseCountry.domain.model.TicketModel
import com.test.search.chooseCountry.domain.repository.TicketsRepository

class TicketsRepositoryImpl(private val api: TicketsApi, private val preferences: Preferences): TicketsRepository {

    override suspend fun getTickets(): List<TicketModel> {
        return api.getTickets().tickets_offers.map { it.toModel() }
    }

    override fun getDestinations(): DestinationsModel {
        return DestinationsModel(preferences.getStart()!!, preferences.getDestination()!!)
    }

}