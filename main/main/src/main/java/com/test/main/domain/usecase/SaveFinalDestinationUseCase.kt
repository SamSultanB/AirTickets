package com.test.main.domain.usecase

import com.test.main.domain.repository.OffersRepository

class SaveFinalDestinationUseCase(private val repository: OffersRepository) {

    fun saveFinalDestination(destination: String){
        repository.finalDestination(destination)
    }

}