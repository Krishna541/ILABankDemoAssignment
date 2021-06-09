package com.ilabank

import android.app.Application

class MyILABankApp : Application() {

    var context: MyILABankApp? = null

    override fun onCreate() {
        super.onCreate()
        context = this
    }


}