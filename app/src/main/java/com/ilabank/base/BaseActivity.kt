package com.ilabank.base

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.Navigation
import com.ilabank.R

abstract class BaseActivity : AppCompatActivity(), BaseInterFace, LifecycleOwner {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var reslayout = InflateLayout()

        // Inflate View by Passing Layout from fragment  / Activity
        if (reslayout != 0) {
            val binding = DataBindingUtil.setContentView(this, reslayout) as ViewDataBinding
            UIInitialization(binding)
        }

    }

}
