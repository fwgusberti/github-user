package br.com.nerdrapido.myapplication.presentation.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.nerdrapido.myapplication.data.model.User
import br.com.nerdrapido.myapplication.domain.usecases.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created By FELIPE GUSBERTI @ 08/02/2022
 */
class UserViewModel(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _user: MutableLiveData<User> = MutableLiveData()
    val user: LiveData<User>
        get() = _user

    fun loadUser() {
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.execute()
            _user.postValue(user)
        }
    }

}