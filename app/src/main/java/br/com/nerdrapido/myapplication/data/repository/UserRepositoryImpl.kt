package br.com.nerdrapido.myapplication.data.repository

import br.com.nerdrapido.myapplication.data.model.User
import br.com.nerdrapido.myapplication.data.remote.service.UserService
import br.com.nerdrapido.myapplication.domain.repository.UserRepository

/**
 * Created By FELIPE GUSBERTI @ 08/02/2022
 */
class UserRepositoryImpl(
    private val userService: UserService
) : UserRepository {

    override suspend fun getUser(): User {
        return userService.getUser()
    }
}