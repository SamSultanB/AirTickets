package com.test.search.chooseCountry.domain.usecase

import com.test.search.chooseCountry.domain.repository.TicketsRepository

class GetDestinationsUseCase(private val repository: TicketsRepository) {

    fun getDestinations() = repository.getDestinations()

}