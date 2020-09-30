package io.github.erikjhordanrey.atp_rankings_di.common.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

inline fun <reified T : ViewModel> AppCompatActivity.viewModelProvidersOf(viewModelFactory: ViewModelProvider.Factory): T =
        ViewModelProvider(this, viewModelFactory)[T::class.java]
