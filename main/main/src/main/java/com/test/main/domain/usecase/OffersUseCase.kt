package com.test.main.domain.usecase

import com.test.main.domain.repository.OffersRepository

class OffersUseCase(private val repository: OffersRepository) {

    suspend fun getOffers() = repository.getOffers()

}