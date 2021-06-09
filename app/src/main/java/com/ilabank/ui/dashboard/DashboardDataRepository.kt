package com.ilabank.ui.dashboard

import com.ilabank.R
import com.ilabank.models.pojo.ListItemModel
import com.ilabank.models.pojo.ListItemDataModel


class DashboardDataRepository {

    val datalist = mutableListOf<ListItemModel>()

    fun GetdynamicListData(
        sliderimagelistCount: Int = 1,
        recyclerlistItemCount: Int = 1
    ): List<ListItemModel> {
        datalist.clear()

        /*Fill Viewpager listitem & Recyclerview Dynamically with static Item Count*/

        for (i in 1..sliderimagelistCount) {
            val tempdatalist = mutableListOf<ListItemDataModel>()
            for (k in 1..recyclerlistItemCount) {
                tempdatalist.add(
                    ListItemDataModel(
                        id = i,
                        SliderImageDataId = k,
                        sliderimage = R.mipmap.app_icon,
                        imagetext = "ILA Bank ${i.times(0).plus(k)}"
                    )
                )
            }

            datalist.add(
                ListItemModel(
                    sliderimageId = i,
                    SliderImage = R.mipmap.slider_image,
                    data = tempdatalist
                )
            )
        }

        return datalist

        /*END*/
    }

}