package com.example.nkmm.base
import androidx.lifecycle.ViewModel as AndroidXViewModel
import androidx.lifecycle.viewModelScope as androidXViewModelScope

actual abstract class ViewModel : AndroidXViewModel() {
    actual val viewModelScope = androidXViewModelScope
    actual override fun onCleared() { super.onCleared() }
}