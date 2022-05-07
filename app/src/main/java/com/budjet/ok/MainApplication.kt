package com.budjet.ok

import android.app.Application
import androidx.lifecycle.MutableLiveData

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
    companion object{
        var currency= MutableLiveData<String>()
        var currencyIcon= MutableLiveData<String>()
    }
}