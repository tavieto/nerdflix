package br.com.usemobile.nerdflix.domain

class VerifyIfExistLocalDataUseCase(
    private val localRepository: LocalRepository
) {

    suspend fun verifyIfExistLocalData(): Boolean {
        return localRepository.verifyIfExistLocalData()
    }

}