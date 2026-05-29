package com.example.dependancyinjection_3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UserViewModel @Inject constructor(val userRepository: UserRepository) : ViewModel(){

    private val _users = MutableStateFlow<List<Posts>>(emptyList())

    val users: StateFlow<List<Posts>> = _users

    private val _endpoint = MutableStateFlow<List<Endpoint>>(emptyList())
    val endpoint : StateFlow<List<Endpoint>> = _endpoint

    fun fetchUsers(){
        viewModelScope.launch {
            _users.value = userRepository.getUsers()
        }
    }

    fun fetchEndpoint(userId: Int){
        viewModelScope.launch {
            _endpoint.value = userRepository.getEndpoint(userId)
        }
    }

    val character: Flow<PagingData<Result>> = userRepository.getPosts()

}