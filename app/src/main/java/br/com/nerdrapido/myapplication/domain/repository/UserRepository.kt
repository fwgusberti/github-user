package br.com.nerdrapido.myapplication.domain.repository

import br.com.nerdrapido.myapplication.data.model.User

/**
 * Created By FELIPE GUSBERTI @ 08/02/2022
 */
interface UserRepository {

    suspend fun getUser(): User
}