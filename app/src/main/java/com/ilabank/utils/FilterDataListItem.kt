package com.ilabank.utils

import android.util.Log
import android.widget.Filter
import com.ilabank.models.pojo.ListItemDataModel

class FilterDataListItem<T>(
    private val dataListItem: List<ListItemDataModel>,
    val onFilter: (List<T>) -> Unit
) : Filter() {

    override fun publishResults(ch: CharSequence?, p1: FilterResults?) {
        try {
            onFilter(p1?.values as List<T>)
        } catch (e: Exception) {
            Log.d("exception", e.printStackTrace().toString())
        }
    }

    override fun performFiltering(ch: CharSequence?): FilterResults {
        var filteredrecyclerList = mutableListOf<ListItemDataModel>()
        if (!ch.isNullOrEmpty()) {
            for (i in dataListItem) {
                if (i.imagetext.contains(ch))
                    filteredrecyclerList.add(i)
            }
        } else {
            filteredrecyclerList = dataListItem.toMutableList()
        }

        return FilterResults().apply { values = filteredrecyclerList }
    }



}