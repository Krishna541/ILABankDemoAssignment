package com.ilabank.ui.dashboard

import androidx.recyclerview.widget.DiffUtil
import com.ilabank.models.pojo.ListItemDataModel

class ListDataItemCallback : DiffUtil.ItemCallback<ListItemDataModel>() {
    override fun areItemsTheSame(
        firstItem: ListItemDataModel,
        secondItem: ListItemDataModel
    ): Boolean {
        return  true
//        return oldItem.SliderImageDataId == newItem.SliderImageDataId
    }

    override fun areContentsTheSame(
        firstItem: ListItemDataModel,
        secondItem: ListItemDataModel
    ): Boolean {
        return false
//        return oldItem == newItem
    }
}