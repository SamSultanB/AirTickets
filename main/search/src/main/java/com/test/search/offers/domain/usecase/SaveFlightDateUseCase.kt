package com.test.search.offers.domain.usecase

import com.test.search.offers.domain.repository.TicketOffersRepository

class SaveFlightDateUseCase(private val repository: TicketOffersRepository){

    fun saveFlightDate(flightDate: String) = repository.saveFlightDate(flightDate)

}