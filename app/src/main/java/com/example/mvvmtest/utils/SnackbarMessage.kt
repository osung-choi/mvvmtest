package com.example.mvvmtest.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

class SnackbarMessage: SingleLiveEvent<Int>() {
    fun observe(owner: LifecycleOwner, observe: (Int) -> Unit) {
        super.observe(owner, Observer {
            it?.run {
                observe(it)
            }
        })
    }
}

class SnackbarMessageString: SingleLiveEvent<String>() {
    fun observe(owner: LifecycleOwner, observer: (String) -> Unit) {
        super.observe(owner, Observer {
            it?.run {
                observer(it)
            }
        })
    }
}