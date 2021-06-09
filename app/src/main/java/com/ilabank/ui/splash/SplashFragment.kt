package com.ilabank.ui.splash

import android.view.View
import androidx.databinding.ViewDataBinding
import com.ilabank.R
import com.ilabank.base.BaseActivity
import com.ilabank.base.BaseFragment
import com.ilabank.databinding.FragmentSplashBinding
import com.ilabank.utils.Constant.Companion.DELAY_TIME
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment() {

    lateinit var fragmentsplashbinding: FragmentSplashBinding

    override fun onResume() {
        super.onResume()
        redirectToDashboard()
    }

    fun redirectToDashboard(){
        fragmentsplashbinding.imgLogo.postDelayed({
            moveToDashboardFragment(R.id.redirect_splash_to_dashboardFragment)
        }, DELAY_TIME)
    }

    override fun onError(error: String) {
    }

    override fun onBack() {
    }

    override fun getLayoutID(): Int {
        return R.layout.fragment_splash
    }

    override fun onIntializedView(binding: ViewDataBinding, view: View) {
        fragmentsplashbinding = binding as FragmentSplashBinding
    }
}