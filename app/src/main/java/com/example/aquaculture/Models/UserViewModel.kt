package com.example.aquaculture.Models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aquaculture.Repository.UserRepository

class UserViewModel : ViewModel(){

    private val repository : UserRepository = UserRepository().getInstance()
    private val _allUsers = MutableLiveData<List<User>>()
    val allUsers : LiveData<List<User>> = _allUsers

    init{
        repository.loadUsers(_allUsers)
    }
}