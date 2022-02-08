package br.com.nerdrapido.myapplication.data.remote.service

import br.com.nerdrapido.myapplication.data.model.User
import retrofit2.http.GET

/**
 * Created By FELIPE GUSBERTI @ 08/02/2022
 */
interface UserService {

    @GET("users/defunkt")
    suspend fun getUser(): User
}