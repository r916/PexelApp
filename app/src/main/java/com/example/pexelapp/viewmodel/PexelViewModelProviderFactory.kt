package com.example.pexelapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pexelapp.repository.Repository

class PexelViewModelProviderFactory(
    val Repository: Repository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PexelViewModel(Repository) as T
    }

}
