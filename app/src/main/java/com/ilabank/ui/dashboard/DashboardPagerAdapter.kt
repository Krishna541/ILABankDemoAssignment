package com.ilabank.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.ilabank.R
import com.ilabank.databinding.DashboardItemFragmentBinding
import com.ilabank.models.pojo.ListItemModel


class DashboardPagerAdapter : PagerAdapter() {

    var viewpagerdataList: List<ListItemModel> = arrayListOf()

    override fun isViewFromObject(view: View, Object: Any): Boolean {
        return view === Object as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val viewpagerbinding = DataBindingUtil.inflate<DashboardItemFragmentBinding>(
            LayoutInflater.from(container.context),
            R.layout.dashboard_item_fragment,
            container,
            false
        )
        viewpagerbinding.ivSliderImage.setImageResource(viewpagerdataList[position].SliderImage)
        container.addView(viewpagerbinding.root)
        return viewpagerbinding.root
    }

    fun addDataIntoViewPager(list: List<ListItemModel>) {
        viewpagerdataList = list
        notifyDataSetChanged()
    }

    override fun getCount(): Int = viewpagerdataList.size

    override fun destroyItem(container: ViewGroup, position: Int, Object: Any) {
        container.removeView(Object as ConstraintLayout)
    }


}