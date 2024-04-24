package com.test.main.domain.usecase

import com.test.main.domain.repository.OffersRepository

class SaveDestinationUseCase(private val repository: OffersRepository) {

    fun saveDestination(destination: String){
        repository.saveDestination(destination)
    }

}