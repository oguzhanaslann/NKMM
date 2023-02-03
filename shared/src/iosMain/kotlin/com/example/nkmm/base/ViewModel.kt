package com.example.nkmm.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

actual abstract class ViewModel {
    private var hasCleared = false

    private val _scope by lazy {
        ClosableCoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    }

    actual val viewModelScope: CoroutineScope by lazy {
        if (hasCleared) {
            closeWithRuntimeException(_scope)
        }

        return@lazy _scope
    }


    fun clear() {
        hasCleared = true
        closeWithRuntimeException(viewModelScope)
        onCleared()
    }

    actual open fun onCleared() {}

    companion object {
        private fun closeWithRuntimeException(obj: Any?) {
            if (obj is Closeable) {
                try {
                    obj.close()
                } catch (e: Exception) {
                    throw RuntimeException(e)
                }
            }
        }
    }
}