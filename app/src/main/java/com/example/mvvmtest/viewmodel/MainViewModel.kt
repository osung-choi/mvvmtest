package com.example.mvvmtest.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmtest.model.DataModel
import com.example.mvvmtest.retrofit.KakaoSearchSortEnum
import com.example.mvvmtest.retrofit.response.ImageSearchResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val model: DataModel): BaseKotlinViewModel() {
    private val TAG = MainViewModel::class.java.simpleName

    private val _imageSearchResponseLiveData = MutableLiveData<ImageSearchResponse>()
    val imageSearchResponseLiveData : LiveData<ImageSearchResponse>
        get() = _imageSearchResponseLiveData

    fun getImageSearch(query: String, page: Int, size: Int) {
        addDisposable(
            model.getData(query, KakaoSearchSortEnum.Accuracy, page, size)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    it.run {
                        if(documents.size > 0) {
                            //postValue : UI변경 가능
                            //setValue : UI변경 불가능
                            _imageSearchResponseLiveData.postValue(this)
                        }
                    }
                },{
                    Log.d(TAG, "response error : ${it.message}")
                })
        )
    }
}