package com.ilabank.ui.dashboard
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ilabank.base.BaseModel
import com.ilabank.models.pojo.ListItemModel
import com.ilabank.models.pojo.ListItemDataModel
import com.ilabank.utils.Constant.Companion.LIST_ITEM_COUNT
import com.ilabank.utils.Constant.Companion.SLIDER_IMAGE_COUNT

class DashboardViewModel : BaseModel(){

    private val dashboardrepository = DashboardDataRepository()

    val DataItem = MutableLiveData<List<ListItemModel>>()
    val listData: LiveData<List<ListItemModel>> = DataItem

    private val GetSelectedListData = MutableLiveData<List<ListItemDataModel>>()
    val selectedListRecyclerItemData: LiveData<List<ListItemDataModel>> = GetSelectedListData

    /* Function to bind / Fill Data in Recyclerview*/
    fun passDatatoFillRecyclerView(listData : List<ListItemDataModel>){
        GetSelectedListData.value = listData
    }
    /*END*/

    /*set Dataitem value from dynamiclist from repository*/
    init {
        DataItem.value =
            dashboardrepository.GetdynamicListData(SLIDER_IMAGE_COUNT, LIST_ITEM_COUNT)
    }

    /*END*/

    fun getpositionwiseListData(position: Int) : List<ListItemDataModel>? {
        return DataItem.value?.get(position)?.data ?: listOf()
    }

    fun getDataWithRespectToPosition(position: Int): List<ListItemDataModel> {
        return DataItem.value?.get(position)?.data ?: listOf()
    }


}