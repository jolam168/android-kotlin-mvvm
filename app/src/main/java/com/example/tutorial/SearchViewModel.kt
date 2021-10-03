package com.example.tutorial

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {
    private val githubRepository: GithubRepository = GithubRepository()

    var userListLiveData: MutableLiveData<List<User>> = MutableLiveData()

    init {
        searchUser("")

    }

    fun searchUser(user: String) {
//        if (user != null){
        viewModelScope.launch {
            try {
                val response = githubRepository.getUserList(user)
                if (response.isSuccessful) {
                    userListLiveData.postValue(response.body())
                }
            } catch (e: Exception) {
                e.stackTrace
            }
        }
//        }
    }
}