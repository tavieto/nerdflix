package br.com.usemobile.nerdflix.domain

class DeleteAllLocalDataUseCase(
    private val localRepository: LocalRepository
) {

    suspend fun deleteAll() {
        localRepository.deleteAll()
    }

}