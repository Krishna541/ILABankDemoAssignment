package com.ilabank.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment


abstract class BaseFragment : Fragment(),BaseNavigator {

    private lateinit var baseviewbinding: ViewDataBinding

    override fun onViewCreated(mview: View, savedInstanceState: Bundle?) {
        onIntializedView(baseviewbinding, mview)
        super.onViewCreated(mview, savedInstanceState)
    }

    @Override
    override fun onCreateView(
        layoutinflater: LayoutInflater,
        containerview: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        baseviewbinding = DataBindingUtil.inflate(layoutinflater, getLayoutID(), containerview, false)
        return baseviewbinding.root
    }

    open fun moveToDashboardFragment(@IdRes fragmentID: Int) {
        NavHostFragment.findNavController(this).navigate(fragmentID)
    }


}