package com.example.mvvmtest.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.mvvmtest.viewmodel.BaseKotlinViewModel

abstract class BaseKotlinActivity<T: ViewDataBinding, R: BaseKotlinViewModel> : AppCompatActivity() {
    lateinit var viewDataBinding: T
    abstract val layoutResourceId: Int
    abstract val viewModel: R
    abstract fun initStartView()
    abstract fun initDataBinding()
    abstract fun initAfterBinding()

    private var isSetBackButtonValid = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewDataBinding = DataBindingUtil.setContentView(this, layoutResourceId)

        initStartView()
        initDataBinding()
        initAfterBinding()
    }
}