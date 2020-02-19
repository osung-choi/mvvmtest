package com.example.mvvmtest.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseKotlinViewModel: ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    /*
    * ViewModel은 View와 생명주기를 공유하기 때문에 View 가 종료될때 ViewModel에서 onCleared() 이 호출.
    * 모든 Observable을 클리어한다.
    * */
    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}