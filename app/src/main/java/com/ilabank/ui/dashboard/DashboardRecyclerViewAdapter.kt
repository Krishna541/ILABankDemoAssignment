package com.ilabank.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ilabank.R
import com.ilabank.databinding.DashboardListItemRowBinding
import com.ilabank.models.pojo.ListItemDataModel
import com.ilabank.utils.FilterDataListItem


class DashboardRecyclerAdapter :
    ListAdapter<ListItemDataModel, DashboardRecyclerAdapter.DashboardRecyclerViewHolder>(
        ListDataItemCallback()),
    Filterable {

    var recyclerdataList = listOf<ListItemDataModel>()

    override fun onCreateViewHolder(viewgroup: ViewGroup, viewType: Int): DashboardRecyclerViewHolder {

        return DashboardRecyclerViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(viewgroup.context),
                R.layout.dashboard_list_item_row,
                viewgroup,
                false
            ) as DashboardListItemRowBinding)

    }

    fun setList(data: List<ListItemDataModel>) {
        recyclerdataList = data
        submitList(data)
    }

    /*function to filter data from list */
    override fun getFilter(): Filter {
        return FilterDataListItem<ListItemDataModel>(recyclerdataList) {
            submitList(it)
        }
    }
    /*END*/

    /*Viewholder Class to bind component with Data*/
    class DashboardRecyclerViewHolder(private val mBinding: DashboardListItemRowBinding) :
        RecyclerView.ViewHolder(mBinding.root) {
        fun bind(ListItemItemData: ListItemDataModel) {
            mBinding.sliderImageListItemData = ListItemItemData
            mBinding.executePendingBindings()
        }
    }

    /*END*/


    override fun onBindViewHolder(holder: DashboardRecyclerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

