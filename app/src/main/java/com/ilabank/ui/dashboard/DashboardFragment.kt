package com.ilabank.ui.dashboard

import android.util.Log
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.activityViewModels
import androidx.viewpager.widget.ViewPager
import com.ilabank.R
import com.ilabank.base.BaseFragment
import com.ilabank.databinding.FragmentDashboardBinding
import com.ilabank.utils.TextAfterChange


class DashboardFragment : BaseFragment() {

    /*// Initialize adapter for viewpager recycleradpater and dashboarddata viewmodel*/
    val dashboardViewModel: DashboardViewModel by activityViewModels()
    lateinit var dashboardRecyclerviewAdapter: DashboardRecyclerAdapter
    lateinit var dashboardBinding: FragmentDashboardBinding
    lateinit var DashboardSliderViewpagerAdapter: DashboardPagerAdapter
    /*END*/

    override fun onError(error: String) {
        Log.d("onError",error)
    }

    override fun onBack() {
        activity?.finish()
    }

    override fun getLayoutID(): Int {
        return R.layout.fragment_dashboard
    }

    override fun onIntializedView(binding: ViewDataBinding, view: View) {
        dashboardBinding = binding as FragmentDashboardBinding

        // initialize all listener / Set Sliderpager , Set Adapter for Recyclerview
        init()
        /*END*/
    }

    private fun init() {
        dashboardRecyclerviewAdapter = DashboardRecyclerAdapter()
        setUpSliderViewPager()
        setRecyclerViewAdapter()
        handleListenerforsliderViewpager()
        setDataFromLifeCyclerObserver()
    }


    private fun setUpSliderViewPager() {
        DashboardSliderViewpagerAdapter = DashboardPagerAdapter()
        dashboardBinding.viewpagerSlider.adapter = DashboardSliderViewpagerAdapter
        dashboardBinding.bottomDots.setupWithViewPager(dashboardBinding.viewpagerSlider, true)
    }


    private fun setRecyclerViewAdapter() {
        dashboardViewModel.getpositionwiseListData(0)?.let {
            dashboardViewModel.passDatatoFillRecyclerView(
                it
            )
        }

        if(dashboardRecyclerviewAdapter != null){
            dashboardBinding.txtEmpty.visibility = View.GONE
        }else{
            dashboardBinding.txtEmpty.visibility = View.VISIBLE
        }

        /*Set Adapter of Recyclerview*/
        dashboardBinding.rcyclervwList.adapter = dashboardRecyclerviewAdapter
        /*END*/
    }

    private fun setDataFromLifeCyclerObserver() {
        /* observer viewpager list for Viewpager/Slider image*/
        dashboardViewModel.DataItem.observe(viewLifecycleOwner, {
            DashboardSliderViewpagerAdapter.addDataIntoViewPager(it)
        })
        /*END*/

        /* set List for Recyclerviewlist*/
        dashboardViewModel.selectedListRecyclerItemData.observe(viewLifecycleOwner, {
            dashboardRecyclerviewAdapter.setList(it)
        })
        /*END*/
    }

    /*handle event after page selection*/
    private fun handleListenerforsliderViewpager() {
        dashboardBinding.viewpagerSlider.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
                Log.d("getstate",state.toString())
            }
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                dashboardViewModel.getpositionwiseListData(
                    position
                )?.let {
                    dashboardViewModel.passDatatoFillRecyclerView(
                        it
                    )
                }
            }
        })

        dashboardBinding.edtSearch.setOnClickListener {
            dashboardBinding.motionLayout.transitionToEnd()
        }

        /*Search on TextChange Listener Event*/
        dashboardBinding.edtSearch.addTextChangedListener(TextAfterChange {
            dashboardRecyclerviewAdapter.filter.filter(it)
        })
        /*END*/

        dashboardBinding.edtSearch.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus){
                dashboardBinding.motionLayout.transitionToEnd()
            }
        }

    }
    /*END*/

}