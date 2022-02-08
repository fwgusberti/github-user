package br.com.nerdrapido.myapplication.domain.usecases

import br.com.nerdrapido.myapplication.data.model.User
import br.com.nerdrapido.myapplication.domain.repository.UserRepository

/**
 * Created By FELIPE GUSBERTI @ 08/02/2022
 */
class GetUserUseCase(
    private val userRepository: UserRepository
) {

    suspend fun execute(): User {
        val user = userRepository.getUser()
        return user
    }
}