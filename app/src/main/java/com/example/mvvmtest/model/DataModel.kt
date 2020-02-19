package com.example.mvvmtest.model

import com.example.mvvmtest.retrofit.KakaoSearchService
import com.example.mvvmtest.retrofit.KakaoSearchSortEnum
import com.example.mvvmtest.retrofit.response.ImageSearchResponse
import io.reactivex.Single

interface DataModel {
    fun getData(query: String, sort: KakaoSearchSortEnum, page: Int, size: Int): Single<ImageSearchResponse>
}

class DataModelImpl(private val service: KakaoSearchService): DataModel {

    private val KAKAO_APP_KEY = "d4e98956203d7e854711b0b86704c883"

    override fun getData(
        query: String,
        sort: KakaoSearchSortEnum,
        page: Int,
        size: Int
    ): Single<ImageSearchResponse> {
        return service.searchImage(auth = "KakaoAK $KAKAO_APP_KEY", query = query, sort = sort.sort, page = page, size = size)
    }
}