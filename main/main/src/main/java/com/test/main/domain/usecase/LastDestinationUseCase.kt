package com.test.main.domain.usecase

import com.test.main.domain.repository.OffersRepository

class LastDestinationUseCase(private val repository: OffersRepository) {

    fun getLastDestination() = repository.getLastDestination()

}